package com.promineotech.realestate.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.promineotech.realestate.entity.Property;
import com.promineotech.realestate.entity.PropertyStatus;
import com.promineotech.realestate.entity.PropertyType;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultRealEstateSalesDao implements RealEstateSalesDao {

  /*
   * Inject a named parameter JDBC template
   */
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  
  
  @Override
  public List<Property> fetchProperties(PropertyType propertyType, PropertyStatus propertyStatus) {
    log.debug("DAO: propertyType={} and propertyStatus={}", propertyType.toString(), propertyStatus.toString());
    
    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM properties "
        + "WHERE property_id = :property_id";
    //@formatter:on
    
    Map<String, Object> params = new java.util.HashMap<>();
    params.put("property_id", propertyType.toString());
    params.put("property_status", propertyStatus.toString());
    
    
    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {

          @Override
          public Property mapRow(ResultSet rs, int rowNum) throws SQLException {
            //@formatter:off
            return Property.builder()
                .price(new BigDecimal(rs.getString("price")))
                .propertyId(PropertyType.valueOf(rs.getString("property_id")))
                .propertyPK(rs.getLong("property_pk"))
                .squareFeet(rs.getInt("square_feet"))
                .numBedrooms(rs.getInt("bedrooms"))
                .numBathrooms(rs.getFloat("bathrooms"))
                .propertyStatus(PropertyStatus.valueOf(rs.getString("property_status")))
                .propertyDescription(rs.getString("property_description"))
                .build();
            
            
            //@formatter:on
          }});
  }



}
