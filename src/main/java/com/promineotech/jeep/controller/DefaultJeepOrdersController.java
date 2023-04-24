package com.promineotech.jeep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;
import com.promineotech.service.JeepOrderService;
import lombok.extern.slf4j.Slf4j;

@RestController 
@Slf4j 
public class DefaultJeepOrdersController implements JeepOrderController {
  
  @Autowired
  private JeepOrderService jeepOrderService;
  
  @Override
  public Order creatOrder(OrderRequest orderRequest) {
    log.debug("Order = {}", orderRequest );
    return JeepOrderService.createOrder(orderRequest);
    
    
  }
}