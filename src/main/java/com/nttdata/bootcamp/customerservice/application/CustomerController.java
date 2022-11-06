package com.nttdata.bootcamp.customerservice.application;

import com.nttdata.bootcamp.customerservice.domain.dto.CustomerRequest;
import com.nttdata.bootcamp.customerservice.domain.dto.CustomerResponse;
import com.nttdata.bootcamp.customerservice.infraestructure.ICustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controlador REST para el manejo de los CUSTOMERS
 * El path para la llamada de estos metodos se encuentra
 * seteado en la variable messege.path-customer.
 *
 * @author Pedro Manuel Diaz Santa Maria
 * @version 1.0.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("${message.path-customer}")
@RefreshScope
@Slf4j
public class CustomerController {
  @Autowired
  private ICustomerService service;

  /**
   * Método GetAll.
   * <p>Este metodo devuelve la lista completa de CUSTOMER guardados en
   * la BD.</p>
   *
   * @return Flux < CustomerResponse >
   * @author Pedro Manuel Diaz Santa Maria
   * @version 1.0.0
   */
  @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public Flux<CustomerResponse> getAll() {
    log.info("====> CustomerController: GetAll");
    return service.getAll();
  }

  /**
   * Método GetById
   * <p>Este metodo devuelve un CUSTOMER que tenga el ID
   * recibido en la url.</p>
   *
   * @param id Es la llave para buscar el CUSTOMER
   * @return ResponseEntity < Mono < CustomerResponse > >
   * @author Pedro Manuel Diaz Santa Maria
   * @version 1.0.0
   */
  @GetMapping(path = "/{id}")
  @ResponseBody
  public ResponseEntity<Mono<CustomerResponse>> getById(@PathVariable String id) {
    log.info("====> CustomerController: GetById");
    Mono<CustomerResponse> customerResponseMono = service.getById(id);
    return new ResponseEntity<>(customerResponseMono,
          customerResponseMono != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
  }

  /**
   * Método Save
   *
   * <p>Este metodo se encarga de guardar un CUSTOMER
   * en la base de datos.</p>
   *
   * @param request Objeto del tipo CustomerRequest para guardar
   * @return Mono < CustomerResponse >
   * @author Pedro Manuel Diaz Santa Maria
   * @version 1.0.0
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<CustomerResponse> save(@RequestBody CustomerRequest request) {
    log.info("====> CustomerController: Save");
    return service.save(Mono.just(request));
  }

  /**
   * Método Update
   *
   * <p>Este metodo se encarga de guardar un CUSTOMER
   * en la base de datos.</p>
   *
   * @param request Objeto del tipo CustomerRequest para editar
   * @param id      Es la llave para buscar el CUSTOMER
   * @return Mono < CustomerResponse >
   * @author Pedro Manuel Diaz Santa Maria
   * @version 1.0.0
   */
  @PutMapping("/update/{id}")
  public Mono<CustomerResponse> update(@RequestBody CustomerRequest request,
                                       @PathVariable String id) {
    log.info("====> CustomerController: Update");
    return service.update(Mono.just(request), id);
  }

  /**
   * Método Delete
   *
   * <p>Este metodo se encarga de eliminar un CUSTOMER
   * en la base de datos.</p>
   *
   * @param id Es la llave para buscar el CUSTOMER
   * @return Mono < ResponseEntity < Void > >
   * @author Pedro Manuel Diaz Santa Maria
   * @version 1.0.0
   */
  @DeleteMapping("/delete/{id}")
  public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
    log.info("====> CustomerController: Delete");
    return service.delete(id)
          .map(r -> ResponseEntity.ok()
                .<Void>build())
          .defaultIfEmpty(ResponseEntity.notFound().build());
  }
}
