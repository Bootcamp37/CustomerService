package com.nttdata.bootcamp.customerservice.infraestructure;

import com.nttdata.bootcamp.customerservice.domain.entity.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz ICustomerRepository.
 *
 * <p>Esta interfaz tiene los métodos para
 * el manejo de la BD.</p>
 *
 * @author Pedro Manuel Diaz Santa Maria
 * @version 1.0.0
 */
@Repository
public interface ICustomerRepository extends ReactiveMongoRepository<Customer, String> {
}
