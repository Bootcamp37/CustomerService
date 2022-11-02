package com.nttdata.bootcamp.CustomerService.domain;

import com.nttdata.bootcamp.CustomerService.domain.dto.CustomerRequest;
import com.nttdata.bootcamp.CustomerService.domain.dto.CustomerResponse;
import com.nttdata.bootcamp.CustomerService.infraestructure.ICustomerMapper;
import com.nttdata.bootcamp.CustomerService.infraestructure.ICustomerRepository;
import com.nttdata.bootcamp.CustomerService.infraestructure.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {
    @Autowired
    private final ICustomerRepository repository;
    @Autowired
    private final ICustomerMapper mapper;
    @Autowired
    private final CustomerValidate validate;

    @Override
    public Flux<CustomerResponse> getAll() {
        // Retorna todos los elemntos de la bd
        return repository.findAll()
                // convierte todos los entity en response
                .map(mapper::toResponse);
    }

    @Override
    public Mono<CustomerResponse> getById(String id) {
        // Retorna el elemento que tenga el id
        return repository.findById(id)
                // convierte el entity en response
                .map(mapper::toResponse)
                // si no existe elemento retorna error
                .switchIfEmpty(Mono.error(RuntimeException::new));
    }

    @Override
    public Mono<CustomerResponse> save(Mono<CustomerRequest> request) {
        // Valida el request
        return request.filter(validate)
                // Convierte el request en entity
                .map(mapper::toEntity)
                // Guarda el entity en el repository
                .flatMap(repository::save)
                // Convierte el entity en response
                .map(mapper::toResponse)
                // Si no es valido retorna error
                .switchIfEmpty(Mono.error(RuntimeException::new));
    }

    @Override
    public Mono<CustomerResponse> update(Mono<CustomerRequest> request, String id) {
        // Validar el request
        return request.filter(validate)
                // Si no es valido retorna error
                .switchIfEmpty(Mono.error(RuntimeException::new))
                .flatMap(item ->
                        // Busca si exite el objeto
                        repository.findById(id)
                                // Si existe el elemento convertimos el objeto request a entity
                                .map(element -> mapper.toEntity(item))
                                // Agregamos el id en el entity
                                .doOnNext(e -> e.setId(id))
                                // guarda el entity en el repository
                                .flatMap(repository::save)
                                // convierte el entity en response
                                .map(mapper::toResponse)
                                // Si no existe retorna error
                                .switchIfEmpty(Mono.error(RuntimeException::new))
                );
    }

    @Override
    public Mono<CustomerResponse> delete(String id) {
        // Retorna el elemento que tenga el id
        return repository.findById(id)
                // Si no existe un elemento retorna error
                .switchIfEmpty(Mono.error(RuntimeException::new))
                // elimina el objeto
                .flatMap(deleteCustomer -> repository.delete(deleteCustomer)
                        // Devuelve el objeto borrado
                        .then(Mono.just(mapper.toResponse(deleteCustomer))));
    }
}
