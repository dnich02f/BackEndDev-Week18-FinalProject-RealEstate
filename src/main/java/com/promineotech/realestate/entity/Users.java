package com.promineotech.realestate.entity;

import lombok.Builder;
import lombok.Data;

/*
 * Step 19: Create a Customer class. Look in the schema and see what the fields of the Customer 
 * table has
 */

@Data
@Builder
public class Users {
  private Long userPK;
  private String firstName;
  private String lastName;
  private String phone;
}
