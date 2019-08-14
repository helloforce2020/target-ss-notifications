package com.target.notifications.models.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.target.notifications.enums.Transport;
import com.target.notifications.models.base.BaseRecepientInfo;

import java.util.List;

import javax.validation.Valid;

public class SmsRecepientInfo extends BaseRecepientInfo {

  public SmsRecepientInfo() {
    this.channel = Transport.SMS;
  }

  @JsonProperty(value = "smsRecipients")
  @Valid
  private List<SmsRecipient> smsRecipients;



}
