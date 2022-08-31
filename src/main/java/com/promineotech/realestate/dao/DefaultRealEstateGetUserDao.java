package com.promineotech.realestate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.promineotech.realestate.entity.Users;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultRealEstateGetUserDao implements RealEstateGetUserDao {

  /*
   * Inject a named parameter JDBC template
   */
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  
  
  @Override
  public List<Users> fetchUsers(String firstName, String lastName){
    log.debug("DAO: first name={} and last name={}", firstName, lastName);
    
    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM users "
        + "WHERE first_name = :first_name AND last_name = :last_name";
    //@formatter:on
    
    Map<String, Object> params = new java.util.HashMap<>();
    params.put("first_name", firstName);
    params.put("last_name", lastName);
    
    
    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {

          @Override
          public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
            //@formatter:off
            return Users.builder()
                .userPK(rs.getLong("user_pk"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .phone(rs.getString("phone"))
                .build();
            
            
            //@formatter:on
          }});
  }



}
