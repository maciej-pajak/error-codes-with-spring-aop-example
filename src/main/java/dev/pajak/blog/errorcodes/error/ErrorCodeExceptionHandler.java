package dev.pajak.blog.errorcodes.error;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@ControllerAdvice
@Slf4j
public class ErrorCodeExceptionHandler {

  @ExceptionHandler(ErrorCodeException.class)
  @ResponseBody
  public ResponseEntity<ErrorDto> handleErrorCodeException(ErrorCodeException exception) {
    final ErrorCode errorCode = exception.getErrorCode();
    log.error("{} ({}), cause: ", errorCode.getMessage(), errorCode.getCode(), exception);
    return new ResponseEntity<>(ErrorDto.create(errorCode.getCode(), errorCode.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @Value
  @AllArgsConstructor(staticName = "create")
  public static class ErrorDto {
    String code;
    String message;
  }

}
