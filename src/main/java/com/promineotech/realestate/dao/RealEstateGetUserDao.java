package com.promineotech.realestate.dao;

import java.util.List;
import com.promineotech.realestate.entity.Users;

public interface RealEstateGetUserDao {

  /**
   * 
   * @param propertyStatus 
   * @param model
   * @param trim
   * @return
   */
  
  List<Users> fetchUsers(String firstName, String lastName);

}
