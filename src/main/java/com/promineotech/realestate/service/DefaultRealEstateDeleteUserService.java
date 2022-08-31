package com.promineotech.realestate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.realestate.dao.RealEstateDeleteUserDao;

/*
 *  Step 30: Now, get the DAO by injecting with Autowired and create the JeepOrderDao interface 
 *  Step 31: return jeepOrderDao, and call the createOrder method (which doesn't exist), create it
 *  Step 32: add the @Service annotation
 *  Step 33: create the Dao implementing class
 */

@Service
public class DefaultRealEstateDeleteUserService implements RealEstateDeleteUserService {

  @Autowired
  private RealEstateDeleteUserDao realEstateDeleteUserDao;
  
  @Transactional
  @Override
  public void deleteUser(int UserPK) {

   realEstateDeleteUserDao.deleteUser(UserPK);
  }
  

}
