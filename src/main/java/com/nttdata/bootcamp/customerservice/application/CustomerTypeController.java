package com.nttdata.bootcamp.customerservice.application;

import com.nttdata.bootcamp.customerservice.domain.entity.CustomerType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Controlador REST para el manejo de los CUSTOMER TYPES
 * El path para la llamada de estos metodos se encuentra
 * seteado en la variable messege.path-customerType.
 *
 * @author Pedro Manuel Diaz Santa Maria
 * @version 1.0.0
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("${message.path-customerType}")
@RefreshScope
@Slf4j
public class CustomerTypeController {
  /**
   * Método GetAll
   * Este metodo devuelve la lista completa de CUSTOMER TYPE guardados en
   * la BD.
   *
   * @return Flux < CustomerResponse >
   * @author Pedro Manuel Diaz Santa Maria
   * @version 1.0.0
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Flux<CustomerType> getAll() {
    log.info("====> CustomerTypeController: GetAll");
    return Flux.fromArray(CustomerType.values());
  }
}
