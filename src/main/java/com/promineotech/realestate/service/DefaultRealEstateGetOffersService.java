package com.promineotech.realestate.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.realestate.dao.RealEstateGetOffersDao;
import com.promineotech.realestate.entity.Offer;

@Service // this is telling Spring to manage this bean/class (Inversion of Control - IoC) it is a candidate for injection
//@Slf4j //logger at the info level
public class DefaultRealEstateGetOffersService implements RealEstateGetOffersService {

  
  @Autowired
  private RealEstateGetOffersDao realEstateGetOffersDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Offer> fetchOffer() {
    
    List<Offer> offers = realEstateGetOffersDao.fetchOffer(); // this is returning an empty list if nothing is found
    
    // throw exception if no properties with the desired property type are found
    if(offers.isEmpty()) {
      String msg = String.format("No offers found");
      throw new NoSuchElementException(msg);
    }
    return offers;
  }

 

}
