package com.nttdata.bootcamp.CustomerService.domain;

import com.nttdata.bootcamp.CustomerService.domain.dto.CustomerRequest;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
@Slf4j
public class CustomerValidate implements Predicate<CustomerRequest> {
    @Override
    public boolean test(@NotNull CustomerRequest request) {
        log.info("====> CustomerValidate: Test");
        return validateFirstname(request.getLastname()) &&
                validateLastname(request.getFirstname());
    }

    public boolean validateFirstname(@NotNull String firstname) {
        log.info("====> CustomerValidate: ValidateFirstname");
        return !firstname.isBlank();
    }

    public boolean validateLastname(@NotNull String lastname) {
        log.info("====> CustomerValidate: ValidateLastname");
        return !lastname.isBlank();
    }
}
