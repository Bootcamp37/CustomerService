package com.nttdata.bootcamp.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Programa principal.
 *
 * @author Pedro Manuel Diaz Santa Maria
 * @version 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
public class CustomerServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerServiceApplication.class, args);
  }

}
