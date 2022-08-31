package com.promineotech.realestate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.realestate.entity.Users;
//import lombok.extern.slf4j.Slf4j;


@Component
//@Slf4j
public class DefaultRealEstateCreateUserDao implements RealEstateCreateUserDao {
  
  private final String sql = ""
      + "INSERT INTO users (first_name, last_name, phone) "
      + "VALUES (:first_name, :last_name, :phone)";
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public Users saveUser(String firstName, String lastName, String phone) {

    /*
     * KeyHolder will return auto-generated keys like the userPK from the users table
     */
    KeyHolder keyHolder = new GeneratedKeyHolder();
    SqlParameterSource parameters = new MapSqlParameterSource()
        .addValue("first_name", firstName).addValue("last_name", lastName).addValue("phone", phone);
    jdbcTemplate.update(sql, parameters, keyHolder);
    
    long id = keyHolder.getKey().intValue();
    return Users.builder()
        .userPK(id).firstName(firstName).lastName(lastName).phone(phone)
        .build();
    
  }


 
}
  