package com.promineotech.baseball.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.baseball.entity.Team;
import com.promineotech.baseball.entity.Player;
import com.promineotech.baseball.entity.Transaction;
import com.promineotech.baseball.entity.FuelType;
import com.promineotech.baseball.entity.Jeep;
import com.promineotech.baseball.entity.JeepModel;
import com.promineotech.baseball.entity.Option;
import com.promineotech.baseball.entity.OptionType;
import com.promineotech.baseball.entity.Order;
import com.promineotech.baseball.entity.Tire;

@Component
public class DefaultJeepOrderDao implements JeepOrderDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public Order saveOrder(Player customer, Jeep jeep, Team color, Transaction engine, Tire tire,
      BigDecimal price, List<Option> options) {
    SqlParams sqlParams = generateInsertSql(customer, jeep, color, engine, tire, price);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    
    jdbcTemplate.update(sqlParams.sql, sqlParams.source, keyHolder);
    
    Long orderPK = keyHolder.getKey().longValue();
    
    saveOptions(options, orderPK);

    return Order.builder()
        .color(color)
        .customer(customer)
        .engine(engine)
        .model(jeep)
        .options(options)
        .orderPK(orderPK)
        .price(price)
        .tire(tire)
        .build();
  }

  private void saveOptions(List<Option> options, Long orderPK) {
    for(Option option : options) {
      SqlParams params = generateInsertSql(option, orderPK);
      jdbcTemplate.update(params.sql, params.source);
    }
  }

  private SqlParams generateInsertSql(Option option, Long orderPK) {
    SqlParams params = new SqlParams();
    params.sql = ""
        + "INSERT INTO order_options ("
        + "option_fk, order_fk"
        + ") VALUES ("
        + ":option_fk, :order_fk"
        + ")";
    params.source.addValue("option_fk", option.getOptionPK());
    params.source.addValue("order_fk", orderPK);
    
    return params;
  }

  private SqlParams generateInsertSql(Player customer, Jeep jeep, Team color,
      Transaction engine, Tire tire, BigDecimal price) {
    String sql = ""
        + "INSERT INTO orders ("
        + "customer_fk, color_fk, engine_fk, tire_fk, model_fk, price"
        + ") VALUES ("
        + ":customer_fk, :color_fk, :engine_fk, :tire_fk, :model_fk, :price"
        + ")";
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("customer_fk", customer.getCustomerPK());
    params.source.addValue("color_fk", color.getColorPK());
    params.source.addValue("engine_fk", engine.getEnginePK());
    params.source.addValue("tire_fk", tire.getTirePK());
    params.source.addValue("model_fk", jeep.getModelPK());
    params.source.addValue("price", price);
    
    return params;
  }

  @Override
  public List<Option> fetchOptions(List<String> optionIds) {
    if (optionIds.isEmpty()) {
      return new LinkedList<>();
    }
    Map<String, Object> params = new HashMap<>();
    String sql = ""
        + "SELECT * "
        + "FROM options "
        + "WHERE option_id IN(";
    for (int index = 0; index < optionIds.size(); index++) {
      String key = "option_" + index;
      sql += ":" + key + ", ";
      params.put(key, optionIds.get(index));
    }

    sql = sql.substring(0, sql.length() - 2);
    sql += ")";

    return jdbcTemplate.query(sql, params, new RowMapper<Option>() {
      @Override
      public Option mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Option.builder()
            .category(OptionType.valueOf(rs.getString("category")))
            .manufacturer(rs.getString("manufacturer"))
            .name(rs.getString("name"))
            .optionId(rs.getString("option_id"))
            .optionPK(rs.getLong("option_pk"))
            .price(rs.getBigDecimal("price"))
            .build();
      }
    });
  }

  @Override
  public Optional<Player> fetchCustomer(String customerId) {
    String sql = "" 
        + "SELECT * " 
        + "FROM customers "
        + "WHERE customer_id = :customer_id";
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customerId);

    return Optional.ofNullable(
        jdbcTemplate.query(sql, params, new CustomerResultSetExtractor()));
  }

  @Override
  public Optional<Jeep> fetchModel(JeepModel model, String trim, int doors) {
    String sql = "" 
        + "SELECT * " 
        + "FROM models "
        + "WHERE model_id = :model_id "
        + "AND trim_level = :trim_level "
        + "AND num_doors = :num_doors";
    Map<String, Object> params = new HashMap<>();
    params.put("model_id", model.toString());
    params.put("trim_level", trim);
    params.put("num_doors", doors);

    return Optional.ofNullable(
        jdbcTemplate.query(sql, params, new ModelResultSetExtractor()));
  }

  @Override
  public Optional<Team> fetchColor(String colorId) {
    String sql = "" 
        + "SELECT * " 
        + "FROM colors " 
        + "WHERE color_id = :color_id";
    Map<String, Object> params = new HashMap<>();
    params.put("color_id", colorId);

    return Optional.ofNullable(
        jdbcTemplate.query(sql, params, new ColorResultSetExtractor()));
  }

  @Override
  public Optional<Transaction> fetchEngine(String engineId) {
    String sql = "" 
        + "SELECT * " 
        + "FROM engines " 
        + "WHERE engine_id = :engine_id";

    Map<String, Object> params = new HashMap<>();
    params.put("engine_id", engineId);

    return Optional.ofNullable(
        jdbcTemplate.query(sql, params, new EngineResultSetExtractor()));
  }

  @Override
  public Optional<Tire> fetchTire(String tireId) {
    String sql = "" 
        + "SELECT * " 
        + "FROM tires " 
        + "WHERE tire_id = :tire_id";

    Map<String, Object> params = new HashMap<>();
    params.put("tire_id", tireId);

    return Optional.ofNullable(
        jdbcTemplate.query(sql, params, new TireResultSetExtractor()));
  }

  class TireResultSetExtractor implements ResultSetExtractor<Tire> {
    @Override
    public Tire extractData(ResultSet rs) throws SQLException {
      rs.next();
      return Tire.builder()
          .manufacturer(rs.getString("manufacturer"))
          .price(rs.getBigDecimal("price"))
          .tireId(rs.getString("tire_id"))
          .tirePK(rs.getLong("tire_pk"))
          .tireSize(rs.getString("tire_size"))
          .warrantyMiles(rs.getInt("warranty_miles"))
          .build();
    }
  }

  class EngineResultSetExtractor implements ResultSetExtractor<Transaction> {
    @Override
    public Transaction extractData(ResultSet rs) throws SQLException {
      rs.next();
      return Transaction.builder()
          .description(rs.getString("description"))
          .engineId(rs.getString("engine_id"))
          .enginePK(rs.getLong("engine_pk"))
          .fuelType(FuelType.valueOf(rs.getString("fuel_type")))
          .hasStartStop(rs.getBoolean("has_start_stop"))
          .mpgCity(rs.getFloat("mpg_city"))
          .mpgHwy(rs.getFloat("mpg_hwy"))
          .name(rs.getString("name"))
          .price(rs.getBigDecimal("price"))
          .sizeInLiters(rs.getFloat("size_in_liters"))
          .build();
    }
  }

  class ColorResultSetExtractor implements ResultSetExtractor<Team> {
    @Override
    public Team extractData(ResultSet rs) throws SQLException {
      rs.next();
      return Team.builder()
          .color(rs.getString("color"))
          .colorId(rs.getString("color_id"))
          .colorPK(rs.getLong("color_pk"))
          .isExterior(rs.getBoolean("is_exterior"))
          .price(rs.getBigDecimal("price"))
          .build();
    }
  }

  class ModelResultSetExtractor implements ResultSetExtractor<Jeep> {
    @Override
    public Jeep extractData(ResultSet rs) throws SQLException {
      rs.next();
      return Jeep.builder()
          .basePrice(rs.getBigDecimal("base_price"))
          .modelId(JeepModel.valueOf(rs.getString("model_id")))
          .modelPK(rs.getLong("model_pk"))
          .numDoors(rs.getInt("num_doors"))
          .trimLevel(rs.getString("trim_level"))
          .wheelSize(rs.getInt("wheel_size"))
          .build();
    }
  }

  class CustomerResultSetExtractor implements ResultSetExtractor<Player> {
    @Override
    public Player extractData(ResultSet rs) throws SQLException {
      rs.next();
      return Player.builder()
          .customerId(rs.getString("customer_id"))
          .customerPK(rs.getLong("customer_pk"))
          .firstName(rs.getString("first_name"))
          .lastName(rs.getString("last_name"))
          .phone(rs.getString("phone"))
          .build();
    }
  }

  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

}