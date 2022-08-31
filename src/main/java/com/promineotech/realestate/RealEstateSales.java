package com.promineotech.realestate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.promineotech.ComponentScanMarker;

/*
 * @SpringBootApplication starts SpringBoot - it is the entry point
 * You can specify what the component scanner scans
 * An interface was created in the com.promineotech package and this interface
 * ComponentScanMarker will negate the possibility of misspelling even if the packages are renamed.
 * If you packages aren't being found, check the ComponentScanner class that you've created.
 */
@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class })
public class RealEstateSales {

  public static void main(String[] args) {
    SpringApplication.run(RealEstateSales.class, args);
  }

}
