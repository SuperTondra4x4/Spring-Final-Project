package com.promineotech.baseball.controller;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.baseball.entity.Order;
import com.promineotech.baseball.entity.OrderRequest;
import com.promineotech.baseball.service.JeepOrderService;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class DefaultJeepOrderController implements JeepOrderController {
  
  @Autowired
  private JeepOrderService jeepOrderService;

  @Override
  public Order createOrder(OrderRequest request) {
    log.info("Controller createOrder request={}", request);
    return jeepOrderService.createOrder(request);
  }

}
