package com.target.notifications.models.email;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.target.notifications.enums.Transport;
import com.target.notifications.models.base.BaseRecepientInfo;

import java.util.List;

import javax.validation.Valid;

public class EmailRecepientInfo extends BaseRecepientInfo {

  public EmailRecepientInfo() {
    this.channel = Transport.EMAIL;
  }

  @JsonProperty(value = "emailRecipients")
  @Valid
  private List<EmailRecipient> emailRecipients;


}
