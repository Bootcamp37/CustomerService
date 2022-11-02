package com.nttdata.bootcamp.CustomerService.infraestructure;

import com.nttdata.bootcamp.CustomerService.domain.dto.CustomerRequest;
import com.nttdata.bootcamp.CustomerService.domain.dto.CustomerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerService {
    Flux<CustomerResponse> getAll();

    Mono<CustomerResponse> getById(String id);

    Mono<CustomerResponse> save(Mono<CustomerRequest> request);

    Mono<CustomerResponse> update(Mono<CustomerRequest> request, String id);

    Mono<CustomerResponse> delete(String id);
}
