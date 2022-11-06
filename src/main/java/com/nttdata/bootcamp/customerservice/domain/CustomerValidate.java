package com.nttdata.bootcamp.customerservice.domain;

import com.nttdata.bootcamp.customerservice.domain.dto.CustomerRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Clase PREDICATE para la validación de la información de un CUSTOMER
 *
 * @author Pedro Manuel Diaz Santa Maria
 * @version 1.0.0
 */
@Component
@Slf4j
public class CustomerValidate implements Predicate<CustomerRequest> {
  @Override
  public boolean test(CustomerRequest request) {
    log.info("====> CustomerValidate: Test");
    return validateFirstname(request.getLastname())
          && validateLastname(request.getFirstname());
  }

  /**
   * Método Validated Firstname.
   *
   * @param firstname Nombre del CUSTOMER.
   * @return Retorna verdadero si el nombre no
   * está en blanco o tiene solo espacios.
   * @author Pedro Manuel Diaz Santa Maria
   * @version 1.0.0
   */
  public boolean validateFirstname(String firstname) {
    log.info("====> CustomerValidate: ValidateFirstname");
    if (Objects.isNull(firstname)) {
      return false;
    }
    return !(firstname.isBlank());
  }

  /**
   * Método Validated Firstname.
   *
   * @param lastname Apellido del CUSTOMER.
   * @return Retorna verdadero si el apellido no
   * está en blanco o tiene solo espacios.
   * @author Pedro Manuel Diaz Santa Maria
   * @version 1.0.0
   */
  public boolean validateLastname(String lastname) {
    log.info("====> CustomerValidate: ValidateLastname");
    if (Objects.isNull(lastname)) {
      return false;
    }
    return !lastname.isBlank();
  }
}
