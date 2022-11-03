package com.nttdata.bootcamp.CustomerService.domain.dto;

import com.nttdata.bootcamp.CustomerService.domain.entity.CustomerSubType;
import com.nttdata.bootcamp.CustomerService.domain.entity.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
