package com.promineotech.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.jeep.entity.Color;
import com.promineotech.jeep.entity.Customer;
import com.promineotech.jeep.entity.Engine;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import com.promineotech.jeep.entity.Option;
import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;
import com.promineotech.jeep.entity.Tire;

public interface JeepOrderService {

  static Order createOrder(OrderRequest orderRequest) {
    return null;
    
  }

  /**
    * 
    */
  Optional<Customer> fetchCustomer(String customerId);

  /**
    * 
    */
  Optional<Jeep> fetchModel(JeepModel model, String trim, int doors);

  /**
    * 
    */
  Optional<Color> fetchColor(String colorId);

  /**
    * 
    */
  Optional<Engine> fetchEngine(String engineId);

  /**
    * 
    */
  Optional<Tire> fetchTire(String tireId);

  /**
    * 
    */
  List<Option> fetchOptions(List<String> optionIds);

}