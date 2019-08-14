package com.target.notifications.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is the BadRequestException. This is thrown in case some invalid fields are passed.
 * 
 * @author vinaymajety
 *
 */
@ResponseStatus(
    value = HttpStatus.BAD_REQUEST,
    reason = "An invalid or missing field was found."
)
public class InvalidFieldException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public InvalidFieldException(String errorMessage) {
    super(errorMessage, null);
  }

  public InvalidFieldException(String errorMessage, Throwable cause) {
    super(errorMessage, cause);
  }

}