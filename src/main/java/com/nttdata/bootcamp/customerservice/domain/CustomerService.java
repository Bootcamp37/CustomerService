package com.nttdata.bootcamp.customerservice.domain;

import com.nttdata.bootcamp.customerservice.domain.dto.CustomerRequest;
import com.nttdata.bootcamp.customerservice.domain.dto.CustomerResponse;
import com.nttdata.bootcamp.customerservice.infraestructure.ICustomerMapper;
import com.nttdata.bootcamp.customerservice.infraestructure.ICustomerRepository;
import com.nttdata.bootcamp.customerservice.infraestructure.ICustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase SERVICE para los principales metodos de CUSTOMER.
 *
 * @author Pedro Manuel Diaz Santa Maria
 * @version 1.0.0
 */
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

  /**
   * Método GetAll.
   *
   * @return Flux < CustomerResponse >
   * @author Pedro Manuel Diaz Santa Maria
   * @version 1.0.0
   */
  @Override
  public Flux<CustomerResponse> getAll() {
    log.info("====> CustomerService: GetAll");
    return repository.findAll()
          .map(mapper::toResponse);
  }

  /**
   * Método GetById.
   *
   * @param id Recibe un ID para buscar al CUSTOMER en la BD
   * @return Mono < CustomerResponse >
   * @author Pedro Manuel Diaz Santa Maria
   * @version 1.0.0
   */
  @Override
  public Mono<CustomerResponse> getById(String id) {
    log.info("====> CustomerService: GetById");
    return repository.findById(id)
          .map(mapper::toResponse)
          .switchIfEmpty(Mono.error(RuntimeException::new));
  }

  /**
   * Método Save.
   *
   * @param request Recibe un CUSTOMER REQUEST para guardar
   * @return Mono < CustomerResponse >
   * @author Pedro Manuel Diaz Santa Maria
   * @version 1.0.0
   */
  @Override
  public Mono<CustomerResponse> save(Mono<CustomerRequest> request) {
    log.info("====> CustomerService: Save");
    return request.map(this::printDebug)
          .filter(validate)
          .map(mapper::toEntity)
          .flatMap(repository::save)
          .map(mapper::toResponse)
          .switchIfEmpty(Mono.error(RuntimeException::new));
  }

  /**
   * Método Update.
   *
   * @param request Recibe un CUSTOMER REQUEST para actualizar
   * @param id      Recibe un ID para buscar al CUSTOMER en la BD
   * @return Mono < CustomerResponse >
   * @author Pedro Manuel Diaz Santa Maria
   * @version 1.0.0
   */
  @Override
  public Mono<CustomerResponse> update(Mono<CustomerRequest> request, String id) {
    log.info("====> CustomerService: Update");
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

  /**
   * Método Delete.
   *
   * @param id Recibe un ID para buscar al CUSTOMER a borrar
   * @return Mono < CustomerResponse >
   * @author Pedro Manuel Diaz Santa Maria
   * @version 1.0.0
   */
  @Override
  public Mono<CustomerResponse> delete(String id) {
    log.info("====> CustomerService: Delete");
    return repository.findById(id)
          .switchIfEmpty(Mono.error(RuntimeException::new))
          .flatMap(deleteCustomer -> repository.delete(deleteCustomer)
                .then(Mono.just(mapper.toResponse(deleteCustomer))));
  }

  /**
   * Método PrintDebug.
   *
   * @param request Recibe un CUSTOMER REQUEST para imprimri
   * @return CustomerRequest
   * @author Pedro Manuel Diaz Santa Maria
   * @version 1.0.0
   */
  public CustomerRequest printDebug(CustomerRequest request) {
    log.info("====> CustomerService: printDebug");
    log.info("====> CustomerService: Request ==> " + request.toString());
    return request;
  }
}
