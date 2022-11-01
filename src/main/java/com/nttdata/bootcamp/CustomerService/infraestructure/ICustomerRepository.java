package com.nttdata.bootcamp.CustomerService.infraestructure;

import com.nttdata.bootcamp.CustomerService.domain.entity.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends ReactiveMongoRepository<Customer, String> {
}
