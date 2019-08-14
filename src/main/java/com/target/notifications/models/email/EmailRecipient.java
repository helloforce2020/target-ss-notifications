package com.target.notifications.models.email;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

import javax.validation.constraints.Pattern;

public class EmailRecipient {

  @JsonProperty(value = "from")
  @Pattern(regexp = "^[a-zA-Z0-9]\\w*?([.+-]\\w+)*@\\w+(?:[.-]\\w+)*(?:\\.[a-zA-Z]{2,15})$",
      message = "Not a valid email id. ex: abc@xyz.com")
  private String from;

  @JsonProperty(value = "to")
  @Pattern(regexp = "^[a-zA-Z0-9]\\w*?([.+-]\\w+)*@\\w+(?:[.-]\\w+)*(?:\\.[a-zA-Z]{2,15})$",
      message = "Not a valid email id. ex: abc@xyz.com")
  @NotBlank
  private List<String> to;

  @JsonProperty(value = "to")
  @Pattern(regexp = "^[a-zA-Z0-9]\\w*?([.+-]\\w+)*@\\w+(?:[.-]\\w+)*(?:\\.[a-zA-Z]{2,15})$",
      message = "Not a valid email id. ex: abc@xyz.com")
  @NotBlank
  private List<String> cc;

  @JsonProperty(value = "bcc")
  @Pattern(regexp = "^[a-zA-Z0-9]\\w*?([.+-]\\w+)*@\\w+(?:[.-]\\w+)*(?:\\.[a-zA-Z]{2,15})$",
      message = "Not a valid email id. ex: abc@xyz.com")
  @NotBlank
  private List<String> bcc;


}
