package com.nttdata.bootcamp.customerservice.domain.mapper;

import com.nttdata.bootcamp.customerservice.domain.dto.CustomerRequest;
import com.nttdata.bootcamp.customerservice.domain.dto.CustomerResponse;
import com.nttdata.bootcamp.customerservice.domain.entity.Customer;
import com.nttdata.bootcamp.customerservice.infraestructure.ICustomerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Clase MAPPER para la conversión de REQUEST a ENTITY y de ENTITY A RESPONSE
 * para la clase CUSTOMER.
 *
 * @author Pedro Manuel Diaz Santa Maria
 * @version 1.0.0
 */
@Component
@Slf4j
public class CustomerMapper implements ICustomerMapper {
  /**
   * Método ToEntity.
   * Este metodo convierte un RESPONSE a ENTITY.
   *
   * @param request No Null - Variable del tipo CUSTOMER REQUEST
   * @return Retorna un objeto ENTITY del CUSTOMER REQUEST
   * @author Pedro Manuel Diaz Santa Maria
   * @version 1.0.0
   */
  @Override
  public Customer toEntity(CustomerRequest request) {
    log.info("====> CustomerMapper: ToEntity");
    Customer customer = new Customer();
    BeanUtils.copyProperties(request, customer);
    return customer;
  }

  /**
   * Método ToEntity.
   * Este metodo convierte un ENTITY a RESPONSE.
   *
   * @param customer No Null - Variable del tipo CUSTOMER ENTITY
   * @return Retorna un objeto RESPONSE del CUSTOMER ENTITY
   * @author Pedro Manuel Diaz Santa Maria
   * @version 1.0.0
   */
  @Override
  public CustomerResponse toResponse(Customer customer) {
    log.info("====> CustomerMapper: ToResponse");
    CustomerResponse customerResponse = new CustomerResponse();
    BeanUtils.copyProperties(customer, customerResponse);
    return customerResponse;
  }
}
