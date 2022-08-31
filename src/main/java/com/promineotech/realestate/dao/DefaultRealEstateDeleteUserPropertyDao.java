package com.promineotech.realestate.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
//import lombok.extern.slf4j.Slf4j;


@Component
//@Slf4j
public class DefaultRealEstateDeleteUserPropertyDao implements RealEstateDeleteUserPropertyDao {
 
  private final String sql = ""
      + "DELETE FROM user_property "
      + "WHERE property_fk = :property_fk";
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public void deleteUserProperty(int propertyPK) {
    
    Map<String, Object> params = new HashMap<>();
    params.put("property_fk", propertyPK);
    if (jdbcTemplate.update(sql, params) == 0)
      throw new NoSuchElementException();
    
  }


 
}
  