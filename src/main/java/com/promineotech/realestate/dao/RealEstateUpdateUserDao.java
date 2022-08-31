package com.promineotech.realestate.dao;

import com.promineotech.realestate.entity.Users;

public interface RealEstateUpdateUserDao {
//  Optional<Users> fetchUser(String userId);

  Users updateUser(Long userPk, String firstName, String lastName, String phone);
}


//  Customer fetchCustomer( String customer);

//  Order createOrder(OrderRequest orderRequest);


