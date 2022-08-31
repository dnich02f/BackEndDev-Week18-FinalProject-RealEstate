package com.promineotech.realestate.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

/*
 * Step 15: reference src/test/jeep.controller.CreateOrderTest
 * this is a data transfer object. We will rename to "OrderRequest" using refactor
 * We need to match what we have in the JSON from src/test/controller.support CreateOrderTestSupport
 * class and "createOrderBody". The names have to be the same as what is in JSON because
 * Jackson will take JSON and convert it into a OrderRequest Object
 * We have an array of options and Jackson will convert that to a list for us -> options
 * Finally, add the @Data annotation that will populate all the getters and setters for the 
 * variables in the class
 * Step 16: found in scr/test/jeep.controller.CreateOrderTest
 * Step 27: Validate OrderRequest for testing. @NotNull, @Length, look at the data in the CustomerId
 * and notice that it is all uppercase with an undercase and @Pattern with a regexp, then back to 
 * CreateOrderTest to run.
 */

@Data
public class OfferRequest {
 @NotNull
 @Length(max = 30)
 @Pattern(regexp = "[\\w\\s]*")
 private String user; 
 
 @NotNull
 private Property property;
 

}
 