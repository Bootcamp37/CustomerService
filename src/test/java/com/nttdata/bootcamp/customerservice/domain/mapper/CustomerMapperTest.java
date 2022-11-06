package com.nttdata.bootcamp.customerservice.domain.mapper;

import com.nttdata.bootcamp.customerservice.domain.dto.CustomerRequest;
import com.nttdata.bootcamp.customerservice.domain.dto.CustomerResponse;
import com.nttdata.bootcamp.customerservice.domain.entity.Customer;
import com.nttdata.bootcamp.customerservice.domain.entity.CustomerType;
import com.nttdata.bootcamp.customerservice.infraestructure.ICustomerMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerMapperTest {
  private ICustomerMapper mapper = new CustomerMapper();

  @Test
  void toEntity() {
    // Recibe un Request
    // Devuelve un Entity
    var customerRequest = new CustomerRequest("Nombre", "Apellido", CustomerType.PERSONAL, null);
    var customer = new Customer(null, "Nombre", "Apellido", CustomerType.PERSONAL, null);
    assertEquals(mapper.toEntity(customerRequest), customer);
  }

  @Test
  void toResponse() {
    // Recibe un Entity
    // Devuelve un Request
    var customer = new Customer("1a1", "Nombre", "Apellido", CustomerType.PERSONAL, null);
    var customerResponse = new CustomerResponse("1a1", "Nombre", "Apellido", CustomerType.PERSONAL, null);
    assertEquals(mapper.toResponse(customer), customerResponse);

  }
}