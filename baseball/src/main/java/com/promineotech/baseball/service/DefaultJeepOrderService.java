package com.promineotech.baseball.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.baseball.dao.JeepOrderDao;
import com.promineotech.baseball.entity.Team;
import com.promineotech.baseball.entity.Player;
import com.promineotech.baseball.entity.Transaction;
import com.promineotech.baseball.entity.Jeep;
import com.promineotech.baseball.entity.Option;
import com.promineotech.baseball.entity.Order;
import com.promineotech.baseball.entity.OrderRequest;
import com.promineotech.baseball.entity.Tire;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultJeepOrderService implements JeepOrderService {
  
  @Autowired
  private JeepOrderDao jeepOrderDao;

  @Transactional
  @Override
  public Order createOrder(OrderRequest request) {
    log.info("Service createOrder request={}", request);
    
    Player customer = getCustomer(request);
    Jeep jeep = getModel(request);
    Team color = getColor(request);
    Transaction engine = getEngine(request);
    Tire tire = getTire(request);
    List<Option> options = getOption(request);
    BigDecimal price = jeep.getBasePrice().add(color.getPrice()).add(engine.getPrice()).add(tire.getPrice());
    
    for(Option option : options) {
      price = price.add(option.getPrice());
    }
    
    return jeepOrderDao.saveOrder(customer, jeep, color, engine, tire, price, options);
  }

  private List<Option> getOption(OrderRequest orderRequest) {
    return jeepOrderDao.fetchOptions(orderRequest.getOptions());
  }

  private Tire getTire(OrderRequest orderRequest) {
    return jeepOrderDao.fetchTire(orderRequest.getTire())
        .orElseThrow(() -> new NoSuchElementException(
            "Tire with ID=" + orderRequest.getTire() + " was not found"));
  }


  private Transaction getEngine(OrderRequest orderRequest) {
    return jeepOrderDao.fetchEngine(orderRequest.getEngine())
        .orElseThrow(() -> new NoSuchElementException(
            "Engine with ID=" + orderRequest.getEngine() + " was not found"));
  }

  private Team getColor(OrderRequest orderRequest) {
    return jeepOrderDao.fetchColor(orderRequest.getColor())
        .orElseThrow(() -> new NoSuchElementException(
            "Color with ID=" + orderRequest.getColor() + " was not found"));
  }

  private Jeep getModel(OrderRequest orderRequest) {
    return jeepOrderDao
        .fetchModel(orderRequest.getModel(), orderRequest.getTrim(),
            orderRequest.getDoors())
        .orElseThrow(() -> new NoSuchElementException("Model with ID="
            + orderRequest.getModel() + ", trim=" + orderRequest.getTrim()
            + orderRequest.getDoors() + " was not found"));
  }

  private Player getCustomer(OrderRequest orderRequest) {
    return jeepOrderDao.fetchCustomer(orderRequest.getCustomer())
        .orElseThrow(() -> new NoSuchElementException("Customer with ID="
            + orderRequest.getCustomer() + " was not found"));
  }
}