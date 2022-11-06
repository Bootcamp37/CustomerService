package com.nttdata.bootcamp.customerservice.infraestructure;

import com.nttdata.bootcamp.customerservice.domain.dto.CustomerRequest;
import com.nttdata.bootcamp.customerservice.domain.dto.CustomerResponse;
import com.nttdata.bootcamp.customerservice.domain.entity.Customer;

/**
 * Interfaz ICustomerMapper.
 *
 * <p>Esta interfaz tiene los métodos que se deben
 * implementar para el funcionamiento del sistema.</p>
 *
 * @author Pedro Manuel Diaz Santa Maria
 * @version 1.0.0
 */
public interface ICustomerMapper {
  Customer toEntity(CustomerRequest request);

  CustomerResponse toResponse(Customer customer);
}
