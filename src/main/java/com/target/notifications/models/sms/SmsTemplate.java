package com.target.notifications.models.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.target.notifications.models.base.BaseTemplate;

public class SmsTemplate extends BaseTemplate {

  @JsonProperty(value = "handlerName")
  private String handlerName;

  @JsonProperty(value = "logoUrl")
  private String logoUrl;

  @JsonProperty(value = "header")
  private String header;

  @Override
  public String toString() {
    return "SmsTemplate [handlerName=" + handlerName + ", logoUrl=" + logoUrl + ", header=" + header
        + ", content=" + content + ", variables=" + variables + "]";
  }

}