package com.promineotech.realestate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.realestate.entity.Users;
import com.promineotech.realestate.service.RealEstateUpdateUserService;
import lombok.extern.slf4j.Slf4j;





@RestController
@Slf4j
public class BasicRealEstateUpdateUserController implements RealEstateUpdateUserController {

  @Autowired
  private RealEstateUpdateUserService realEstateUpdateUserService;

  @Override
  public Users updateUser(Long userPk, String firstName, String lastName, String phone) {
    log.debug("firstName={} and lastName={}", firstName, lastName);
    return realEstateUpdateUserService.updateUser(userPk, firstName, lastName, phone);
  }

}
