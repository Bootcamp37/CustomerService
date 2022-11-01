package com.nttdata.bootcamp.CustomerService.domain.mapper;

import com.nttdata.bootcamp.CustomerService.domain.dto.CustomerRequest;
import com.nttdata.bootcamp.CustomerService.domain.dto.CustomerResponse;
import com.nttdata.bootcamp.CustomerService.domain.entity.Customer;
import com.nttdata.bootcamp.CustomerService.infraestructure.ICustomerMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper implements ICustomerMapper {
    @Override
    public Customer toEntity(@NotNull CustomerRequest request) {
        Customer customer = new Customer();
        customer.setFirstname(request.getFirstname());
        customer.setLastname(request.getLastname());
        customer.setCustomerType(request.getCustomerType());
        return customer;
    }

    @Override
    public CustomerResponse toResponse(@NotNull Customer customer) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setFirstname(customer.getFirstname());
        customerResponse.setLastname(customer.getLastname());
        customerResponse.setCustomerType(customer.getCustomerType());
        return customerResponse;
    }
}