package com.promineotech.realestate.dao;

import java.util.List;
import com.promineotech.realestate.entity.Offer;

public interface RealEstateGetOffersDao {

  /**
   * 
   * @param propertyStatus 
   * @param model
   * @param trim
   * @return
   */
  
  List<Offer> fetchOffer();

}
