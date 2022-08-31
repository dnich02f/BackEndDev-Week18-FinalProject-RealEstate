package com.promineotech.realestate.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.realestate.dao.RealEstateSalesDao;
import com.promineotech.realestate.entity.Property;
import com.promineotech.realestate.entity.PropertyStatus;
import com.promineotech.realestate.entity.PropertyType;
import lombok.extern.slf4j.Slf4j;

@Service // this is telling Spring to manage this bean/class (Inversion of Control - IoC) it is a candidate for injection
@Slf4j //logger at the info level
public class DefaultRealEstateSalesService implements RealEstateSalesService {

  
  @Autowired
  private RealEstateSalesDao realEstateSalesDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Property> fetchProperties(PropertyType propertyType, PropertyStatus propertyStatus) {
 log.info("The fetchProperties method was called with PropertyType={} and PropertyStatus={}, propertyType, propertyStatus");    
    
    List<Property> properties = realEstateSalesDao.fetchProperties(propertyType, propertyStatus); // this is returning an empty list if nothing is found
    
    // throw exception if no properties with the desired property type are found
    if(properties.isEmpty()) {
      String msg = String.format("No properties found with property type=%s or property status=%s", propertyType, propertyStatus);
      throw new NoSuchElementException(msg);
    }
    
    Collections.sort(properties);
    return properties;
  }

 

}
