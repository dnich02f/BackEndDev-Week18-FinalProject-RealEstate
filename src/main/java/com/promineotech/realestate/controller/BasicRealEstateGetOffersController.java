package com.promineotech.realestate.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.realestate.entity.Offer;
import com.promineotech.realestate.service.RealEstateGetOffersService;

/*
 * Implementing the JeepSalesController interface
 * You have to tell Spring that this controller is a REST controller. This has to be done in the class
 * not the interface.
 * Now Spring knows that this class is something special and it's a controller that implements JeepSalesController
 * So Spring will go the interface from here and follow that OpenApi Documentation
 */

@RestController
//@Slf4j // this is a LOMBOK annotation and created log of type Logger
public class BasicRealEstateGetOffersController implements RealEstateGetOffersController {
  
  
  @Autowired // we want an objected to be injected here
  private RealEstateGetOffersService realEstateGetOffersService;
  
  @Override
  public List<Offer> fetchOffer(
      
      ) {
    
    return realEstateGetOffersService.fetchOffer(); 
        }
  
//  @Override
//  public String uploadImage(MultipartFile image, Long jeepPK) {
//    log.debug("image={}, jeepPK={}", image, jeepPK);
//    return "Success!";
//  }


}
