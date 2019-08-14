package com.target.notifications.models.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.Pattern;

public class SmsRecipient {

  /*
   * Primary number and secondary number are left out of details due to the existing contract.
   */
  @JsonProperty(value = "primaryNumber")
  @JsonPropertyDescription(value = "primary mobileNumber of recipient")
  @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "Invalid International Phone Number")
  private String primaryNumber;

  @JsonProperty(value = "secondaryNumber")
  @JsonPropertyDescription(value = "secondary mobileNumber of recipient")
  @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "Invalid International Phone Number")
  private String secondaryNumber;

}
