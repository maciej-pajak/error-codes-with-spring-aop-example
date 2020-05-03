package dev.pajak.blog.errorcodes.error;

import lombok.Getter;

public class ErrorCodeException extends RuntimeException {

  @Getter
  private final ErrorCode errorCode;

  public ErrorCodeException(ErrorCode errorCode, Throwable cause) {
    super(errorCode.getMessage(), cause);
    this.errorCode = errorCode;
  }

}
