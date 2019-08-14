package com.target.notification.utils;

import com.target.notifications.exceptions.BadRequestException;
import com.target.notifications.exceptions.InternalErrorException;
import com.target.notifications.exceptions.InvalidFieldException;
import com.target.notifications.exceptions.NotFoundException;

import org.apache.commons.collections4.MapUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This is a wrapper class for Exception handling.
 * 
 * @author vinaymajety
 *
 */
public class ExceptionUtil {

  private static final String INVALID_FIELDS_PASSED = "Invalid fields passed : ";

  private ExceptionUtil() {

  }

  /**
   * This method throws InvalidFieldException.
   * 
   * @param objectName the name of the affected object
   * @param field the affected field of the object
   * @param errorMsg the default message to be used to resolve the error.
   */
  public static void throwInvalidFieldException(final String objectName, final String field, final String errorMsg) {
    final List<String> fieldErrors = new ArrayList<>();
    fieldErrors.add(field);
    throw new InvalidFieldException(getExceptionMessage(objectName, fieldErrors));
  }

  private static String getExceptionMessage(final String objectName, final List<String> fieldErrors) {
    return INVALID_FIELDS_PASSED + fieldErrors + ", for object = " + objectName;
  }

  /**
   * This method throws InvalidFieldException.
   * 
   * @param objectName the name of the affected object
   * @param fieldToErrorMsgMap Map of the affected field to errorMsg.
   */
  public static void throwInvalidFieldException(final String objectName, final Map<String, String> fieldToErrorMsgMap) {
    if (MapUtils.isEmpty(fieldToErrorMsgMap)) {
      return;
    }
    final List<String> fieldErrors = new ArrayList<>();
    fieldToErrorMsgMap.forEach((field, errorMsg) -> {
      fieldErrors.add(field);
    });
    throw new InvalidFieldException(getExceptionMessage(objectName, fieldErrors));
  }

  /**
   * This method throws InvalidFieldException.
   * 
   * @param objectName the name of the affected object
   * @param fieldToErrorMsgMap Map of the affected field to errorMsg.
   */
  public static void throwInvalidFieldExceptionWithMultipleErrorMsgs(final String objectName,
      final Map<String, List<String>> fieldToErrorMsgMap) {
    final List<String> fieldErrors = new ArrayList<>();
    fieldToErrorMsgMap.forEach((field, errorMsgs) -> errorMsgs.forEach(errorMsg -> {
      fieldErrors.add(field);
    }));
    throw new InvalidFieldException(getExceptionMessage(objectName, fieldErrors));
  }

  /**
   * Throws not found exception.
   * 
   * @param format
   * @param args
   * @return
   */
  public static NotFoundException notFoundException(final String format, final Object... args) {
    return notFoundException(String.format(format, args));
  }

  /**
   * Returns NotFoundException.
   * 
   * @param msg
   * @return
   */
  public static NotFoundException notFoundException(final String msg) {
    return new NotFoundException(getExceptionMessage(msg, new ArrayList<>()));
  }

  /**
   * Returns InternalErrorException.
   * 
   * @param msg
   * @param cause
   * @return
   */
  public static InternalErrorException internalErrorException(final String msg, final Throwable cause) {
    return new InternalErrorException(getExceptionMessage(msg, new ArrayList<>()));

  }

  /**
   * Returns BadRequestException.
   * 
   * @param msg
   * @param cause
   * @return
   */
  public static BadRequestException badRequestException(final String msg, final Throwable cause) {
    return new BadRequestException(getExceptionMessage(msg, new ArrayList<>()));
  }

}
