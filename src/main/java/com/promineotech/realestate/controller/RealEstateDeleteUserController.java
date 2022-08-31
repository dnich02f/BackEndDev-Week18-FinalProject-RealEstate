package com.promineotech.realestate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.realestate.entity.Users;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated 
/*
 * need to add validated in order for Bean validation to be effective
 */

/*
 * Need to tell Spring how to handle method, class, and request parameters
 * In Package com.promineotech.jeep.controller.support, BaseTest class, getBaseUri method,
 * we refer to /jeeps. -> return String.format("http://localhost:%d/offers", serverPort);
 * SO, any URI that has /jeeps after the port number will get mapped to this class
 */
@RequestMapping("/deleterealestateuser")

/*
 * OpenAPI also accessed through swagger-ui in the browser
 */
@OpenAPIDefinition(info = @Info(title = "Real Estate Offer and Investing Service"), // Service name will appear on Swagger Documentation
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})


/*
 * Need to add documentation for FetchOffer method
 */
public interface RealEstateDeleteUserController {

  //@formatter:off
  @Operation(
      summary = "Deletes a user from the application",
      description = "Deletes a user from the application",
      responses = {
          @ApiResponse(responseCode = "201", description = "The user has been deleted", content = @Content(mediaType = "application/json", 
              schema = @Schema (implementation = Users.class))), // okay/success
          @ApiResponse(responseCode = "400", description = "The request parameters are invalid", content = @Content(mediaType = "application/json")), // illegal request
          @ApiResponse(responseCode = "404", description = "A user with the parameter was not found", content = @Content(mediaType = "application/json")), // not found 
          @ApiResponse(responseCode = "500", description = "An unplanned error occured", content = @Content(mediaType = "application/json")) // unplanned exception
      }
//      ,
//      parameters = {
//          
//           @Parameter(name = "user_pk", allowEmptyValue = false, required = true, description = "The user's primary key")
//      }
//      
   )
  
  /*
   * Map get request to /order to createOrder method using PostMapping
   */
  @DeleteMapping // Delete 
  @ResponseStatus(code = HttpStatus.OK)
  void deleteUser(int UserPK);
  //@formatter:on
  
  
  
  /*
   * Spring will map all requests with /offers to the RealEstateOfferController class
   * Spring will map all getRequests with /order to the ...  method
   */
}
