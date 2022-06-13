package com.promineotech.baseball.service;

import com.promineotech.baseball.entity.Order;
import com.promineotech.baseball.entity.OrderRequest;

public interface JeepOrderService {

  Order createOrder(OrderRequest request);

}
