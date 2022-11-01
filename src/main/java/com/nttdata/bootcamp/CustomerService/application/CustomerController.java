package com.nttdata.bootcamp.CustomerService.application;

import com.nttdata.bootcamp.CustomerService.domain.dto.CustomerRequest;
import com.nttdata.bootcamp.CustomerService.domain.dto.CustomerResponse;
import com.nttdata.bootcamp.CustomerService.infraestructure.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("${message.path-customer}")
@RefreshScope
public class CustomerController {
    @Autowired
    private ICustomerService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<CustomerResponse> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public Mono<CustomerResponse> getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public Mono<CustomerResponse> save(@RequestBody CustomerRequest request) {
        return service.save(request);
    }

    @PutMapping("/update/{id}")
    public Mono<CustomerResponse> update(@RequestBody CustomerRequest request, @PathVariable String id) {
        return service.update(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<CustomerResponse> delete(@PathVariable String id) {
        return service.delete(id);
    }
}
