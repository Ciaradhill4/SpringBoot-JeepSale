package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import com.promineotech.jeep.controller.support.CreateOrderTestSupport;
import com.promineotech.jeep.entity.JeepModel;
import com.promineotech.jeep.entity.Order;
import lombok.Getter;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {"classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
    "classpath:flyway/migrations/V1.1__Jeep_Data.sql"},
    config = @SqlConfig(encoding = "utf-8"))

class CreateOrderTest extends CreateOrderTestSupport { 
  
  @LocalServerPort 
  private int serverPort;
  
  @Autowired
  @Getter
    private TestRestTemplate restTemplate;
  
  /**
   * 
   * @return
   */
    protected String getBaseUriForJeeps() {
      return String.format("htt[://localhost:%d/jeeps", serverPort);
      }
   /**
     * 
     * @return
     */
    protected String getBaseUriForOrders() {
      return String.format("htt[://localhost:%d/orders", serverPort);
       }

  /**
   * 
   */
  @Test
  void testCreateOrderResturnsSuccess201() {
      
    //Given: an order at JSON
    String body = createOrderBody();
    String uri = getBaseUriForOrders();
    
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON); 
    
    HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers);
    
    //When: the order is sent
    ResponseEntity<Order> response = restTemplate.exchange(uri, 
        HttpMethod.POST, bodyEntity, Order.class);
        
    
    //Then: a 201 status is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
 
    
    //And: the returned order is correct
    assertThat(response.getBody()).isNotNull();
    
    Order order = response.getBody(); 

    assertThat(order.getCustomer().getCustomerId()).isEqualTo("MORISON_LINA"); 
    assertThat(order.getModel().getModelId()).isEqualTo(JeepModel.WRANGLER); 
    assertThat(order.getModel().getTrimLevel()).isEqualTo("Sport Altitude"); 
    assertThat(order.getModel().getNumDoors()).isEqualTo(4); 
    assertThat(order.getColor().getColorId()).isEqualTo("EXT_DIAMOND_BLACK"); 
    assertThat(order.getEngine().getEngineId()).isEqualTo("2_0_TURBO"); 
    assertThat(order.getTire().getTireId()).isEqualTo("255_GOODYEAR"); 
    assertThat(order.getOptions()).hasSize(6); 
    
  }
}
