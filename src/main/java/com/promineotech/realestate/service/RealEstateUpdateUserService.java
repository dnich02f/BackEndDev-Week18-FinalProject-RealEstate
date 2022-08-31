package com.promineotech.realestate.service;

import com.promineotech.realestate.entity.Users;

public interface RealEstateUpdateUserService {

  Users updateUser(Long userPk, String firstName, String lastName, String phone);

}
