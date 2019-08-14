package com.target.notifications.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is the BadRequestException. This is thrown in case some resources are not found.
 * 
 * @author vinaymajety
 *
 */

@ResponseStatus(
    value = HttpStatus.NOT_FOUND,
    reason = "Could not find resource specfied in request URI."
)
public class NotFoundException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public NotFoundException(String errorMessage) {
    super(errorMessage, null);
  }

  public NotFoundException(String errorMessage, Throwable cause) {
    super(errorMessage, cause);
  }


}
