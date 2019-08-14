package com.target.notifications.exceptions;

public enum NotificationErrorCodes {

  NOTIFICATION_SCHEDULER_ERROR("NOTIFICATION-V2-1", "Error while scheduling notification",
      "Error while scheduling notification"),
  ELASTIC_SEARCH_REQUEST_ERROR("ELASTIC_SEARCH_REQUEST_ERROR", "Error while executing search. Verify request",
      "Verify the search request");

  private final String code;
  private final String message;
  private final String description;

  NotificationErrorCodes(String code, String message, String description) {
    this.code = code;
    this.message = message;
    this.description = description;
  }

  public String getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public String getDescription() {
    return this.description;
  }

}
