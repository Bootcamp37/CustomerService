package com.nttdata.bootcamp.CustomerService.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
}
