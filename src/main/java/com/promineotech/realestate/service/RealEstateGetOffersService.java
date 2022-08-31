package com.promineotech.realestate.service;

import java.util.List;
import com.promineotech.realestate.entity.Offer;

public interface RealEstateGetOffersService {

  /**
   * @param propertyStatus 
   * @param model
   * @param trim
   * @return
   * 
   * why create the interface? If one person was working on the Controller layer and another
   * worked on the Service layer, this interface provides definition and structure for each
   * developer to continue working together, interfaces are easy to mock
   * 
   */
  
  List<Offer> fetchOffer();

}
 