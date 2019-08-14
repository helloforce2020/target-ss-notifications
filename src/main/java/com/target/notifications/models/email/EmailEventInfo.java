package com.target.notifications.models.email;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.target.notifications.enums.Transport;
import com.target.notifications.models.base.BaseEventInfo;

import org.hibernate.validator.constraints.NotBlank;

import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

public class EmailEventInfo extends BaseEventInfo {

  @JsonProperty(value = "templates")
  @JsonPropertyDescription(value = "email Template per locale")
  @Valid
  private Map<Locale, EmailTemplate> templates;

  @JsonProperty(value = "defaultLocale")
  @JsonPropertyDescription(value = "Default locale to send sms")
  private Locale defaultLocale;

  @JsonProperty(value = "deliveryReportUrl")
  @Pattern(regexp = "(http|https)://[a-zA-Z0-9\\-_~]+(\\.[a-zA-Z\\-_~]+)+(:[0-9]{4})?(/[a-zA-Z0-9\\-_~]+)+",
      message = "Not a valid url. ex: http://www.google.com/v1")
  private String deliveryReportUrl;

  @JsonProperty(value = "from")
  @Pattern(regexp = "[a-zA-Z0-9\\-_\\.]+@[a-zA-Z]+(\\.[a-zA-Z]+)+", message = "Not a valid email id. ex: abc@xyz.com")
  @Valid
  @NotBlank
  private String from;

  public Map<Locale, EmailTemplate> getTemplates() {
    return templates;
  }

  public void setTemplates(Map<Locale, EmailTemplate> templates) {
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

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }


  public EmailEventInfo() {
    this.transport = Transport.EMAIL;
  }


}
