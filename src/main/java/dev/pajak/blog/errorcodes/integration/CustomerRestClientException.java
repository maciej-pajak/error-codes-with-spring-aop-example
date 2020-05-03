package dev.pajak.blog.errorcodes.integration;

public class CustomerRestClientException extends RuntimeException {

  public CustomerRestClientException(String message) {
    super(message);
  }

}
