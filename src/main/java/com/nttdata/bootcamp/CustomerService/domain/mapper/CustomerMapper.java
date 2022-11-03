package com.nttdata.bootcamp.CustomerService.domain.mapper;

import com.nttdata.bootcamp.CustomerService.domain.dto.CustomerRequest;
import com.nttdata.bootcamp.CustomerService.domain.dto.CustomerResponse;
import com.nttdata.bootcamp.CustomerService.domain.entity.Customer;
import com.nttdata.bootcamp.CustomerService.infraestructure.ICustomerMapper;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomerMapper implements ICustomerMapper {
    @Override
    public Customer toEntity(@NotNull CustomerRequest request) {
        log.debug("====> CustomerMapper: ToEntity");
        Customer customer = new Customer();
        BeanUtils.copyProperties(request, customer);
        return customer;
    }

    @Override
    public CustomerResponse toResponse(@NotNull Customer customer) {
        log.debug("====> CustomerMapper: ToResponse");
        CustomerResponse customerResponse = new CustomerResponse();
        BeanUtils.copyProperties(customer, customerResponse);
        return customerResponse;
    }
}
