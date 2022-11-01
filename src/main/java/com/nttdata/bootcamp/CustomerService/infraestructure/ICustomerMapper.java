package com.nttdata.bootcamp.CustomerService.infraestructure;

import com.nttdata.bootcamp.CustomerService.domain.dto.CustomerRequest;
import com.nttdata.bootcamp.CustomerService.domain.dto.CustomerResponse;
import com.nttdata.bootcamp.CustomerService.domain.entity.Customer;

public interface ICustomerMapper {
    Customer toEntity(CustomerRequest request);

    CustomerResponse toResponse(Customer customer);
}
