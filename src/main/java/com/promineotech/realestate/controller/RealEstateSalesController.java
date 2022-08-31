package com.promineotech.realestate.controller;

/*
 * WHAT IS A CONTROLLER LAYER? with OPEN API DOCUMENTATION TO DESCRIBE THE CONTROLLER
 * A Controller is a layer of code that intercepts a http request, sends the request to service layer, 
 * receives response from service layer, formats the response back to the client (browser, js), etc
 * 
 * WHY AN INTERFACE? To write all of the required annotations that implementing classes will implement.
 */

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.realestate.entity.Property;
import com.promineotech.realestate.entity.PropertyStatus;
import com.promineotech.realestate.entity.PropertyType;
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
 * In Package com.promineotech.realestate.controller.support, BaseTest class, getBaseUri method,
 * we refer to /getrealestate. -> return String.format("http://localhost:%d/getrealestate", serverPort);
 * SO, any URI that has /realestate after the port number will get mapped to this class
 */
@RequestMapping("/getrealestate")

/*
 * OpenAPI also accessed through swagger-ui in the browser
 */
@OpenAPIDefinition(info = @Info(title = "Real Estate Sales Service"), //Real Estate Sales Service will appear on Swagger Documentation
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})


/*
 * Need to add documentation for FetchProperty method
 */
public interface RealEstateSalesController {

  //@formatter:off
  @Operation(
      summary = "Return a list of Real Estate",
      description = "Returns a list of Real Estate given an optional price or square foot",
      responses = {
          @ApiResponse(responseCode = "200", description = "A list of Real Estate is returned", content = @Content(mediaType = "application/json", 
              schema = @Schema (implementation = Property.class))), // okay/success
          @ApiResponse(responseCode = "400", description = "The request parameters are invalid", content = @Content(mediaType = "application/json")), // illegal request
          @ApiResponse(responseCode = "404", description = "No Real Estate were found with the input criteria", content = @Content(mediaType = "application/json")), // not found 
          @ApiResponse(responseCode = "500", description = "An unplanned error occured", content = @Content(mediaType = "application/json")) // unplanned exception
      },
      parameters = {
//           @Parameter(name = "price", allowEmptyValue = false, required = false, description = "Enter desired price (i.e., '300000.00)'"),
/*
 * ***Decided not to include the PropertyType parameter, and instead allow the user to select from a list of options to minimize errors***
 */
//           @Parameter(name = "PropertyType", allowEmptyValue = false, required = false, description = "Enter desired PropertyType (i.e., 'SINGLE_FAMILY', 'MULTI_FAMILY', 'COMMERCIAL')")
      }
      
   )
 
  /*
   * Map get request to /getrealestate to fetchProperties method using GetMapping
   */
  @GetMapping // GET 
  @ResponseStatus(code = HttpStatus.OK)
  List<Property> fetchProperties(
      @RequestParam(required = false) PropertyType propertyType,
      @RequestParam(required = false) PropertyStatus propertyStatus
      );
  //@formatter:on
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
//  
//  @PostMapping("/{propertyPK}/image")
//  @ResponseStatus(code = HttpStatus.OK)
//  String uploadImage(@RequestParam("image")MultipartFile image, 
//      @PathVariable Long propertyPK);
//  
  /*
   * Spring will map all requests with /jeeps to the JeepSalesController class
   * Spring will map all getRequests with /jeeps to the FetchJeeps method
   */
}
