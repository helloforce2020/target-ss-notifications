package com.target.notifications.models.webhooks;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.target.notifications.enums.Transport;
import com.target.notifications.models.base.BaseRecepientInfo;

import java.util.List;

import javax.validation.Valid;

public class WebhookRecepientInfo extends BaseRecepientInfo {

  public WebhookRecepientInfo() {
    this.channel = Transport.WEBHOOKS;
  }

  @JsonProperty(value = "webHooksRecipients")
  @Valid
  private List<WebhookRecipient> webHooksRecipients;


}
