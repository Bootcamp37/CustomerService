package com.nttdata.bootcamp.customerservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase ENTITY para el manejo de los CUSTOMERS en BD.
 *
 * @author Pedro Manuel Diaz Santa Maria
 * @version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers")
public class Customer {
  @Id
  private String id;
  private String firstname;
  private String lastname;
  private CustomerType customerType;
  private CustomerSubType subType = null;
}
