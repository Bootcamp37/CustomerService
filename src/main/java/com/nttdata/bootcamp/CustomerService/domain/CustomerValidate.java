package com.nttdata.bootcamp.CustomerService.domain;

import com.nttdata.bootcamp.CustomerService.domain.dto.CustomerRequest;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class CustomerValidate implements Predicate<CustomerRequest> {
    @Override
    public boolean test(CustomerRequest request) {
        // Valida que el nombre y el apellido no estan en blanco
        return validateFirstname(request.getLastname()) &&
                validateLastname(request.getFirstname());
    }

    public boolean validateFirstname(String firstname) {
        // Si el nombre esta en blanco retorna false
        return !firstname.isBlank();
    }

    public boolean validateLastname(String lastname) {
        // Si el apellido esta en blanco retorna false
        return !lastname.isBlank();
    }
}
