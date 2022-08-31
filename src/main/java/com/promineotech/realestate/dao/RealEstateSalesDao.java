package com.promineotech.realestate.dao;

import java.util.List;
import com.promineotech.realestate.entity.Property;
import com.promineotech.realestate.entity.PropertyStatus;
import com.promineotech.realestate.entity.PropertyType;

public interface RealEstateSalesDao {

  /**
   * 
   * @param propertyStatus 
   * @param model
   * @param trim
   * @return
   */
  
  List<Property> fetchProperties(PropertyType propertyType, PropertyStatus propertyStatus);

}
