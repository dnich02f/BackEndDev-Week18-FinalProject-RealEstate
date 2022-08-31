package com.promineotech.realestate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.promineotech.realestate.entity.Offer;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultRealEstateGetOffersDao implements RealEstateGetOffersDao {

  /*
   * Inject a named parameter JDBC template
   */
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  
  
  @Override
  public List<Offer> fetchOffer(){
    log.debug("DAO: list of offers retrieved");
    
    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM offers ";
    //@formatter:on
    
    Map<String, Object> params = new java.util.HashMap<>();
//    params.put("first_name", firstName);
//    params.put("last_name", lastName);
//    
    
    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {

          @Override
          public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
            //@formatter:off
            return Offer.builder()
                .offerPK(rs.getLong("offer_pk"))
                .userFK(rs.getLong("user_fk"))
                .propertyFK(rs.getLong("property_fk"))
                .price(rs.getBigDecimal("price"))
                .build();
            
            
            //@formatter:on
          }});
  }



}
