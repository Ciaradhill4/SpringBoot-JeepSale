package com.promineotech.jeep.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;
import com.promineotech.service.JeepOrderService;
import lombok.extern.slf4j.Slf4j;

@RestController 
@Service
@Slf4j 
public class DefaultJeepOrdersController implements JeepOrderController {
  
  @Autowired
  private JeepOrderService jeepOrderService;
  
  @Override
  public Order createOrder(@Valid OrderRequest orderRequest) {
    log.debug("Order = {}", orderRequest);
    return jeepOrderService.createOrder(orderRequest);
  }
}
