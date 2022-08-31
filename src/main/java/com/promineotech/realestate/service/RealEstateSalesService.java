package com.promineotech.realestate.service;

import java.util.List;
import com.promineotech.realestate.entity.Property;
import com.promineotech.realestate.entity.PropertyStatus;
import com.promineotech.realestate.entity.PropertyType;

public interface RealEstateSalesService {

  /**
   * @param propertyStatus 
   * @param model
   * @param trim
   * @return
   * 
   * why create the interface? If one person was working on the Controller layer and another
   * worked on the Service layer, this interface provides definition and structure for each
   * developer to continue working together, interfaces are easy to mock
   * 
   */
  
  List<Property> fetchProperties(PropertyType propertyType, PropertyStatus propertyStatus);

}
 