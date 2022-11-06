package com.nttdata.bootcamp.customerservice.infraestructure;

import com.nttdata.bootcamp.customerservice.domain.dto.CustomerRequest;
import com.nttdata.bootcamp.customerservice.domain.dto.CustomerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz ICustomerService.
 *
 * <p>Esta interfaz tiene los métodos que se deben
 * implementar para el funcionamiento del service.</p>
 *
 * @author Pedro Manuel Diaz Santa Maria
 * @version 1.0.0
 */

public interface ICustomerService {
  Flux<CustomerResponse> getAll();

  Mono<CustomerResponse> getById(String id);

  Mono<CustomerResponse> save(Mono<CustomerRequest> request);

  Mono<CustomerResponse> update(Mono<CustomerRequest> request, String id);

  Mono<CustomerResponse> delete(String id);
}
