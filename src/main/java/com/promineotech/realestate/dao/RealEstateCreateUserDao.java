package com.promineotech.realestate.dao;

import com.promineotech.realestate.entity.Users;

public interface RealEstateCreateUserDao {
//  Optional<Users> fetchUser(String userId);

  Users saveUser(String firstName, String lastName, String phone);
}


//  Customer fetchCustomer( String customer);

//  Order createOrder(OrderRequest orderRequest);


