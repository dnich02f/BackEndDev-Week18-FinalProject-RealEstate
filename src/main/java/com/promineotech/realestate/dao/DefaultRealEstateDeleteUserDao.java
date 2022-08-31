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
public class DefaultRealEstateDeleteUserDao implements RealEstateDeleteUserDao {
 
  private final String sql = ""
      + "DELETE FROM users "
      + "WHERE user_pk = :user_pk";
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public void deleteUser(int UserPK) {
    
    Map<String, Object> params = new HashMap<>();
    params.put("user_pk", UserPK);
    if (jdbcTemplate.update(sql, params) == 0)
      throw new NoSuchElementException();
    
  }


 
}
  