package com.target.notifications.models.webhooks;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.target.notifications.models.base.BaseEventInfo;

public class WebhookEventInfo extends BaseEventInfo {

  @JsonProperty(value = "webhooksTemplate")
  private WebhooksTemplate webhooksTemplate; // with parameters
  
}