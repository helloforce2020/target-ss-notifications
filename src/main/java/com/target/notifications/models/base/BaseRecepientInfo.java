package com.target.notifications.models.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.target.notifications.enums.Transport;

import java.util.Locale;
import java.util.Map;

public class BaseRecepientInfo {

  @JsonProperty(value = "locale")
  @JsonPropertyDescription(value = "Locale of the recipient")
  private Locale locale;

  @JsonProperty(value = "variables")
  @JsonPropertyDescription(
      value = "variable values used for template substitution. key-value pairs")
  private Map<String, Object> variables;

  protected Transport channel;

  public Locale getLocale() {
    return locale;
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  public Map<String, Object> getVariables() {
    return variables;
  }

  public void setVariables(Map<String, Object> variables) {
    this.variables = variables;
  }

  public Transport getChannel() {
    return channel;
  }

  public void setChannel(Transport channel) {
    this.channel = channel;
  }

}