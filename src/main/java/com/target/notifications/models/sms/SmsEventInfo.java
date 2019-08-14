package com.target.notifications.models.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.target.notifications.enums.Transport;
import com.target.notifications.models.base.BaseEventInfo;

import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

public class SmsEventInfo extends BaseEventInfo {

  @JsonProperty(value = "templates")
  @JsonPropertyDescription(value = "Sms Template per locale")
  @Valid
  private Map<Locale, SmsTemplate> templates;

  @JsonProperty(value = "defaultLocale")
  @JsonPropertyDescription(value = "Default locale to send sms")
  private Locale defaultLocale;

  @JsonProperty(value = "deliveryReportUrl")
  @Pattern(regexp = "(http|https)://[a-zA-Z0-9\\-_~]+(\\.[a-zA-Z\\-_~]+)+(:[0-9]{4})?(/[a-zA-Z0-9\\-_~]+)+",
      message = "Not a valid url. ex: http://www.google.com/v1")
  private String deliveryReportUrl;

  // @JsonProperty(value = "urlCondition")
  // private DeliveryReportUrlCondition urlCondition;

  @JsonProperty(value = "deliveryReportEmail")
  @Pattern(regexp = "[a-zA-Z0-9\\-_\\.]+@[a-zA-Z]+(\\.[a-zA-Z]+)+", message = "Not a valid email id. ex: abc@xyz.com")
  private String deliveryReportEmail;

  public Map<Locale, SmsTemplate> getTemplates() {
    return templates;
  }

  public void setTemplates(Map<Locale, SmsTemplate> templates) {
    this.templates = templates;
  }

  public Locale getDefaultLocale() {
    return defaultLocale;
  }

  public void setDefaultLocale(Locale defaultLocale) {
    this.defaultLocale = defaultLocale;
  }

  public String getDeliveryReportUrl() {
    return deliveryReportUrl;
  }

  public void setDeliveryReportUrl(String deliveryReportUrl) {
    this.deliveryReportUrl = deliveryReportUrl;
  }

  public String getDeliveryReportEmail() {
    return deliveryReportEmail;
  }

  public void setDeliveryReportEmail(String deliveryReportEmail) {
    this.deliveryReportEmail = deliveryReportEmail;
  }

  public SmsEventInfo() {
    this.transport = Transport.SMS;
  }

}
