package com.target.notifications.models.email;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.target.notifications.enums.MessageContentType;
import com.target.notifications.models.base.BaseTemplate;

import javax.validation.constraints.Size;

public class EmailTemplate extends BaseTemplate {

  @JsonProperty(value = "subject")
  @JsonPropertyDescription(value = "subject of the message")
  @Size(min = 5, max = 120)
  private String subject;

  @JsonProperty(value = "addUnsubscribeFooter")
  private boolean addUnsubscribeFooter;

  @JsonProperty(value = "unsubscribeFooter")
  private String htmlUnsubscribeFooter;

  @JsonProperty(value = "contentType")
  @JsonPropertyDescription(value = "content type for the text message")
  private MessageContentType contentType;

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public boolean isAddUnsubscribeFooter() {
    return addUnsubscribeFooter;
  }

  public void setAddUnsubscribeFooter(boolean addUnsubscribeFooter) {
    this.addUnsubscribeFooter = addUnsubscribeFooter;
  }

  public String getHtmlUnsubscribeFooter() {
    return htmlUnsubscribeFooter;
  }

  public void setHtmlUnsubscribeFooter(String htmlUnsubscribeFooter) {
    this.htmlUnsubscribeFooter = htmlUnsubscribeFooter;
  }

  public MessageContentType getContentType() {
    return contentType;
  }

  public void setContentType(MessageContentType contentType) {
    this.contentType = contentType;
  }

}
