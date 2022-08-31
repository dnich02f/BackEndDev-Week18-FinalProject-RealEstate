package com.promineotech.realestate.entity;

import java.math.BigDecimal;
import java.util.Comparator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

/*
 * This adds sorting capability so that our test doesn't break
 */
public class Property implements Comparable<Property>{
  private Long propertyPK;
  private PropertyType propertyId;
  private int squareFeet;
  private int numBedrooms;
  private float numBathrooms;
  private int yearBuilt;
  private BigDecimal price;
  private int rental_income;
  private PropertyStatus propertyStatus;
  private String propertyDescription;
  
  
//  @JsonIgnore
//  public Long getPropertyPK() {
//    return propertyPK;
//  }


  @Override
  public int compareTo(Property that) {

    /*
     * :: is a method reference operator
     */
    return Comparator.comparing(Property::getPropertyId).thenComparing(Property::getPrice)
        .thenComparing(Property::getNumBedrooms).compare(this, that);
  }


//  @Override
//  public int compareTo(Property o) {
//    // TODO Auto-generated method stub
//    return 0;
//  }
}
