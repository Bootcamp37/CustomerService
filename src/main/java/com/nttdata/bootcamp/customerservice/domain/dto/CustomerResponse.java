package com.nttdata.bootcamp.customerservice.domain.dto;

import com.nttdata.bootcamp.customerservice.domain.entity.CustomerSubType;
import com.nttdata.bootcamp.customerservice.domain.entity.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase DTO para el manejo de los CUSTOMERS RESPONSE.
 *
 * @author Pedro Manuel Diaz Santa Maria
 * @version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
  private String id;
  private String firstname;
  private String lastname;
  private CustomerType customerType;
  private CustomerSubType subType;
}
