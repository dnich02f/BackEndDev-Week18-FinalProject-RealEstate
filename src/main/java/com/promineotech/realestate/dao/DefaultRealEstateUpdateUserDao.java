package com.promineotech.realestate.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.realestate.entity.Users;
import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class DefaultRealEstateUpdateUserDao implements RealEstateUpdateUserDao {
  
  private final String sql = ""
      + "UPDATE users "
      + "SET first_name = :first_name, last_name = :last_name, phone = :phone "
      + "WHERE user_pk = :user_pk";
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public Users updateUser(Long userPk, String firstName, String lastName, String phone) {

    Map<String, Object> params = new HashMap<>();
    params.put("user_pk", userPk);
    params.put("first_name", firstName);
    params.put("last_name", lastName);
    params.put("phone", phone);
    
    if (jdbcTemplate.update(sql, params) == 0) {
      throw new NoSuchElementException();
    } else {
      log.info("Update user succeeded.");
    }
    
    return 
        Users.builder().
        userPK(userPk).
        firstName(firstName).
        lastName(lastName).
        phone(phone).
        build();
  }
}
  