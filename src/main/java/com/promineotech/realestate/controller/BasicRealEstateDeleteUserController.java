package com.promineotech.realestate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.realestate.service.RealEstateDeleteUserService;
import lombok.extern.slf4j.Slf4j;

/*
 * Step 22: implement the createOrder method as declared in the JeepOrderController interface
 * Step 23: add @RestController, and log the line that says the createOrder method is there
 * with Slf4j which is from Lombok
 * Step 24: go to scr/test/jeep.controller.CreateOrderTest
 * Step 28: Create an JeepOrderService interface and put it in the service package
 * Step 29: code createOrder to return createOrder from the JeepOrderService interface
 */





@RestController
@Slf4j
public class BasicRealEstateDeleteUserController implements RealEstateDeleteUserController {

  @Autowired
  private RealEstateDeleteUserService realEstateDeleteUserService;

  @Override
  public void deleteUser(int UserPK) {
    log.debug("userPK={}", UserPK);
    realEstateDeleteUserService.deleteUser(UserPK);
  }

}
