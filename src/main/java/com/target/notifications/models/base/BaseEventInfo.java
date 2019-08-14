package com.target.notifications.models.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.target.notifications.enums.Transport;

public class BaseEventInfo {

  @JsonProperty(value = "retryCount")
  private int retryCount;

  @JsonProperty(value = "templateId")
  private String templateId;
  
  protected Transport transport;

  public int getRetryCount() {
    return retryCount;
  }

  public void setRetryCount(int retryCount) {
    this.retryCount = retryCount;
  }

  public String getTemplateId() {
    return templateId;
  }

  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }

  public Transport getTransport() {
    return transport;
  }

  public void setTransport(Transport transport) {
    this.transport = transport;
  }

}
