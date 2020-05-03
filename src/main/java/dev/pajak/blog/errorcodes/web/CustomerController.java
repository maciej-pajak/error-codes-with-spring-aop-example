package dev.pajak.blog.errorcodes.web;

import dev.pajak.blog.errorcodes.integration.CustomerRestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerRestClient customerRestClient;

  @GetMapping("/{id}")
  public CustomerRestClient.Customer customer(@PathVariable String id) {
    return customerRestClient.getCustomer(id);
  }

}
