package com.promineotech.realestate.service;

import com.promineotech.realestate.entity.Users;

public interface RealEstateCreateUserService {

  Users saveUser(String firstName, String lastName, String phone);

}
