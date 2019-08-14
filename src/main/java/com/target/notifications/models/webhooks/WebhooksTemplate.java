package com.target.notifications.models.webhooks;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class WebhooksTemplate {
  
  @JsonProperty(value = "content", required = true)
  private Map<String,Object> content; // with parameters

}
