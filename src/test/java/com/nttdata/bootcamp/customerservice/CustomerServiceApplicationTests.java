package com.nttdata.bootcamp.customerservice;

import com.nttdata.bootcamp.customerservice.application.CustomerController;
import com.nttdata.bootcamp.customerservice.domain.CustomerService;
import com.nttdata.bootcamp.customerservice.domain.dto.CustomerResponse;
import com.nttdata.bootcamp.customerservice.domain.entity.CustomerType;
import com.nttdata.bootcamp.customerservice.domain.mapper.CustomerMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(CustomerController.class)
class CustomerServiceApplicationTests {
  @Autowired
  private WebTestClient webTestClient;
  @MockBean
  private CustomerMapper mapper;
  @MockBean
  private CustomerService customerService;
  @Value("${message.path-customer}")
  private String url;

  @Test
  public void getAllTest() {
    /*
    var empFlux = Flux.just(
          new CustomerResponse("1", "abilio", "caceres", CustomerType.PERSONAL, null),
          new CustomerResponse("2", "lidia", "Cori", CustomerType.BUSINESS, null));

    when(customerService.getAll()).thenReturn(empFlux);
    var responseFlux = webTestClient.get()
          .uri(url)
          .exchange()
          .expectStatus()
          .isOk()
          .returnResult(CustomerResponse.class)
          .getResponseBody();
    StepVerifier.create(responseFlux)
          .expectSubscription()
          .expectNext(new CustomerResponse("1", "abilio", "caceres", CustomerType.PERSONAL, null))
          .expectNext(new CustomerResponse("2", "lidia", "Cori", CustomerType.BUSINESS, null))
          .verifyComplete();
     */
  }

  @Test
  public void createCustomer() {
    /*
    var customerRequest = new CustomerRequest("AAA", "BBB", CustomerType.PERSONAL, null);
    var customer = new Customer("2", customerRequest.getFirstname(), customerRequest.getLastname(), customerRequest.getCustomerType(), customerRequest.getSubType());
    var customerResponse = new CustomerResponse(customer.getId(), customer.getFirstname(), customer.getLastname(), customer.getCustomerType(), customer.getSubType());
    var monoCustomerRequest = Mono.just(customerRequest);

    when(customerService.save(monoCustomerRequest))
          .thenReturn(Mono.just(customerResponse));

    webTestClient.post().uri(url)
          .contentType(MediaType.APPLICATION_JSON)
          .accept(MediaType.APPLICATION_JSON)
          .body(monoCustomerRequest, CustomerRequest.class)
          .exchange()
          .expectStatus().isCreated();
          */
  }
}
