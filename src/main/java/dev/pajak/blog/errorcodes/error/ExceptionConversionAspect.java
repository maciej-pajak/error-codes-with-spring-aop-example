package dev.pajak.blog.errorcodes.error;

import dev.pajak.blog.errorcodes.integration.CustomerRestClientException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionConversionAspect {

  @AfterThrowing(pointcut = "execution(* dev.pajak.blog.errorcodes.integration.CustomerRestClient.*(..))", throwing = "exception")
  void convertCustomerRestClientExceptions(Throwable exception) {
    if (exception instanceof CustomerRestClientException) {
      throw ErrorCode.CUSTOMER_RESOURCE_INTERNAL_ERROR.exception(exception);
    } else {
      throw ErrorCode.CUSTOMER_RESOURCE_ERROR.exception(exception);
    }
  }

}
