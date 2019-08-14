package com.target.notifications.models.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BaseTemplate {

  @JsonProperty(value = "content", required = true)
  protected String content; // with parameters

  @JsonProperty(value = "variables")
  protected List<String> variables;
}

