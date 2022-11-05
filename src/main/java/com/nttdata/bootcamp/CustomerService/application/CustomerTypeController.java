package com.nttdata.bootcamp.CustomerService.application;

import com.nttdata.bootcamp.CustomerService.domain.entity.CustomerType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("${message.path-customerType}")
@RefreshScope
public class CustomerTypeController {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<CustomerType> getAll() {
        log.info("====> CustomerTypeController: GetAll");
        return Flux.fromArray(CustomerType.values());
    }
}
