package com.target.notifications.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is the BadRequestException. This is thrown in case request payload is not of compatible format.
 * 
 * @author vinaymajety
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "An bad request was submitted.")
public class BadRequestException extends RuntimeException {
  private static final long serialVersionUID = 1L;


  public BadRequestException(String errorMessage) {
    super(errorMessage, null);
  }

  public BadRequestException(String errorMessage, Throwable cause) {
    super(errorMessage, cause);
  }

}
