package com.promineotech.realestate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.realestate.dao.RealEstateUpdateUserDao;
import com.promineotech.realestate.entity.Users;

/*
 *  Step 30: Now, get the DAO by injecting with Autowired and create the JeepOrderDao interface 
 *  Step 31: return jeepOrderDao, and call the createOrder method (which doesn't exist), create it
 *  Step 32: add the @Service annotation
 *  Step 33: create the Dao implementing class
 */

@Service
public class DefaultRealEstateUpdateUserService implements RealEstateUpdateUserService {

  @Autowired
  private RealEstateUpdateUserDao realEstateUpdateUserDao;
  
  @Transactional
  @Override
  public Users updateUser(Long userPk, String firstName, String lastName, String phone) {

   return realEstateUpdateUserDao.updateUser(userPk, firstName, lastName, phone);
  }
  

}
