package com.nttdata.bootcamp.CustomerService.domain;

import com.nttdata.bootcamp.CustomerService.domain.dto.CustomerRequest;
import com.nttdata.bootcamp.CustomerService.domain.dto.CustomerResponse;
import com.nttdata.bootcamp.CustomerService.infraestructure.ICustomerMapper;
import com.nttdata.bootcamp.CustomerService.infraestructure.ICustomerRepository;
import com.nttdata.bootcamp.CustomerService.infraestructure.ICustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService implements ICustomerService {
    @Autowired
    private final ICustomerRepository repository;
    @Autowired
    private final ICustomerMapper mapper;
    @Autowired
    private final CustomerValidate validate;

    @Override
    public Flux<CustomerResponse> getAll() {
        log.debug("====> CustomerService: GetAll");
        return repository.findAll()
                .map(mapper::toResponse);
    }

    @Override
    public Mono<CustomerResponse> getById(String id) {
        log.debug("====> CustomerService: GetById");
        return repository.findById(id)
                .map(mapper::toResponse)
                .switchIfEmpty(Mono.error(RuntimeException::new));
    }

    @Override
    public Mono<CustomerResponse> save(Mono<CustomerRequest> request) {
        log.debug("====> CustomerService: Save");
        return request.map(this::printDebug)
                .filter(validate)
                .map(mapper::toEntity)
                .flatMap(repository::save)
                .map(mapper::toResponse)
                .switchIfEmpty(Mono.error(RuntimeException::new));
    }

    @Override
    public Mono<CustomerResponse> update(Mono<CustomerRequest> request, String id) {
        log.debug("====> CustomerService: Update");
        return request.map(this::printDebug)
                .filter(validate)
                .flatMap(item ->
                        // Busca si exite el objeto
                        repository.findById(id)
                                .switchIfEmpty(Mono.error(RuntimeException::new))
                                .map(e -> item)
                )
                .map(mapper::toEntity)
                .doOnNext(e -> e.setId(id))
                .flatMap(repository::save)
                .map(mapper::toResponse)
                .switchIfEmpty(Mono.error(RuntimeException::new));
    }

    @Override
    public Mono<CustomerResponse> delete(String id) {
        log.debug("====> CustomerService: Delete");
        return repository.findById(id)
                .switchIfEmpty(Mono.error(RuntimeException::new))
                .flatMap(deleteCustomer -> repository.delete(deleteCustomer)
                        .then(Mono.just(mapper.toResponse(deleteCustomer))));
    }

    public CustomerRequest printDebug(CustomerRequest request){
        log.debug("====> CustomerService: printDebug");
        log.debug("====> CustomerService: Request ==> " + request.toString());
        return request;
    }
}
