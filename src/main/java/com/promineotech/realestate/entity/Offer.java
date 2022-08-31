 package com.promineotech.realestate.entity;
/*
 * Step 18: Create an Order class. Add @Data for Getters and Setters. We want all the things in 
 * the Order Request. 
 * Step 19: Add Customer customer, create a Customer class in src/main/jeep.entity,
 * Jeep class, Color class, Engine class, etc
 */

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Offer {
  private Long offerPK;
  private Users user;
  private Long userFK;
  private Property property;
  private Long propertyFK;
  private BigDecimal price;
  
  @JsonIgnore
  public Long getOfferPK() {
    return offerPK;
  }
}
