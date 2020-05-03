package dev.pajak.blog.errorcodes.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

  CUSTOMER_RESOURCE_ERROR("E00001", "Customer resource error"),
  CUSTOMER_RESOURCE_INTERNAL_ERROR("E00002", "Customer resource internal error");

  private final String code;
  private final String message;

  public ErrorCodeException exception(Throwable cause) {
    return new ErrorCodeException(this, cause);
  }

}
