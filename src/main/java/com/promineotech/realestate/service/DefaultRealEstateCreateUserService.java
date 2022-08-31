package com.promineotech.realestate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.realestate.dao.RealEstateCreateUserDao;
import com.promineotech.realestate.entity.Users;

/*
 *  Step 30: Now, get the DAO by injecting with Autowired and create the JeepOrderDao interface 
 *  Step 31: return jeepOrderDao, and call the createOrder method (which doesn't exist), create it
 *  Step 32: add the @Service annotation
 *  Step 33: create the Dao implementing class
 */

@Service
public class DefaultRealEstateCreateUserService implements RealEstateCreateUserService {

  @Autowired
  private RealEstateCreateUserDao realEstateCreateUserDao;
  
  @Transactional
  @Override
  public Users saveUser(String firstName, String lastName, String phone) {

   return realEstateCreateUserDao.saveUser(firstName, lastName, phone);
  }
  

}
