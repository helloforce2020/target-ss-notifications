package com.target.notifications.enums;

/**
 * Content type of the email body.
 * 
 * @author soumeshsharma
 *
 */
public enum MessageContentType {

  TEXT("plain/text"), HTML("text/html");

  private String contentType;

  MessageContentType(String contentType) {
    this.contentType = contentType;
  }

  public String getContentType() {
    return this.contentType;
  }

}