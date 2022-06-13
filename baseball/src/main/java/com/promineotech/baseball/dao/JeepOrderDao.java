package com.promineotech.baseball.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.promineotech.baseball.entity.Team;
import com.promineotech.baseball.entity.Player;
import com.promineotech.baseball.entity.Transaction;
import com.promineotech.baseball.entity.Jeep;
import com.promineotech.baseball.entity.JeepModel;
import com.promineotech.baseball.entity.Option;
import com.promineotech.baseball.entity.Order;
import com.promineotech.baseball.entity.Tire;

public interface JeepOrderDao {
  List<Option> fetchOptions(List<String> optionIds);

  Optional<Player> fetchCustomer(String customerId);

  Optional<Jeep> fetchModel(JeepModel model, String trim, int doors);

  Optional<Team> fetchColor(String colorId);

  Optional<Transaction> fetchEngine(String engineId);

  Optional<Tire> fetchTire(String tireId);

  Order saveOrder(Player customer, Jeep jeep, Team color, Transaction engine, Tire tire,
      BigDecimal price, List<Option> options);
}