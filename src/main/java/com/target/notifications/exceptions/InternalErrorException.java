package com.target.notifications.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is the BadRequestException. This is thrown in case some internal error is occured.
 * 
 * @author vinaymajety
 *
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "An internal error occured.")
public class InternalErrorException extends RuntimeException {
  private static final long serialVersionUID = 1L;


  public InternalErrorException(String errorMessage) {
    super(errorMessage, null);
  }

  public InternalErrorException(String errorMessage, Throwable cause) {
    super(errorMessage, cause);
  }


}
