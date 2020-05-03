package dev.pajak.blog.errorcodes.integration;

import org.springframework.stereotype.Component;

@Component
public class CustomerRestClient {

  public Customer getCustomer(String id) {
    throw new CustomerRestClientException("dummy exception");
  }

  public static class Customer {
    private String id;
    private String name;
  }

}
