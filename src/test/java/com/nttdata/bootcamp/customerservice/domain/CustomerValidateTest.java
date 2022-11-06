package com.nttdata.bootcamp.customerservice.domain;

import com.nttdata.bootcamp.customerservice.domain.dto.CustomerRequest;
import com.nttdata.bootcamp.customerservice.domain.entity.CustomerSubType;
import com.nttdata.bootcamp.customerservice.domain.entity.CustomerType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerValidateTest {

  CustomerValidate customerValidate = new CustomerValidate();

  @Test
  void test1() {
    var customerRequest = new CustomerRequest("Nombre", "Apellido", CustomerType.PERSONAL, CustomerSubType.VIP);
    assertEquals(customerValidate.test(customerRequest), true);
  }

  @Test
  void validateFirstnameNull() {
    String firstname = null;
    assertEquals(customerValidate.validateFirstname(firstname), false);
  }

  @Test
  void validateFirstnameEmpty() {
    String firstname = "";
    assertEquals(customerValidate.validateFirstname(firstname), false);
  }

  @Test
  void validateFirstnameSpace() {
    String firstname = "                    ";
    assertEquals(customerValidate.validateFirstname(firstname), false);
  }

  @Test
  void validateFirstnameTrue() {
    String firstname = "Nombre";
    assertEquals(customerValidate.validateFirstname(firstname), true);
  }

  @Test
  void validateLastnameNull() {
    String lastname = null;
    assertEquals(customerValidate.validateFirstname(lastname), false);
  }

  @Test
  void validateLastnameEmpty() {
    String lastname = "";
    assertEquals(customerValidate.validateFirstname(lastname), false);
  }

  @Test
  void validateLastnameSpace() {
    String lastname = "            ";
    assertEquals(customerValidate.validateFirstname(lastname), false);
  }

  @Test
  void validateLastname() {
    String lastname = "Apellido";
    assertEquals(customerValidate.validateFirstname(lastname), true);
  }
}