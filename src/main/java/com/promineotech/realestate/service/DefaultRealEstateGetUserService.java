package com.promineotech.realestate.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.realestate.dao.RealEstateGetUserDao;
import com.promineotech.realestate.entity.Users;
import lombok.extern.slf4j.Slf4j;

@Service // this is telling Spring to manage this bean/class (Inversion of Control - IoC) it is a candidate for injection
@Slf4j //logger at the info level
public class DefaultRealEstateGetUserService implements RealEstateGetUserService {

  
  @Autowired
  private RealEstateGetUserDao realEstateGetUserDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Users> fetchUsers(String firstName, String lastName) {
 log.info("The fetchUsers method was called with firstName={} and lastName={}, firstName, lastName");    
    
    List<Users> users = realEstateGetUserDao.fetchUsers(firstName, lastName); // this is returning an empty list if nothing is found
    
    // throw exception if no properties with the desired property type are found
    if(users.isEmpty()) {
      String msg = String.format("No users found with first name=%s or last name=%s", firstName, lastName);
      throw new NoSuchElementException(msg);
    }
    return users;
  }

 

}
