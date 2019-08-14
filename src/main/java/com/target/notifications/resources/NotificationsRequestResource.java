package com.target.notifications.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.target.notifications.enums.Transport;
import com.target.notifications.models.base.BaseRecepientInfo;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationsRequestResource {

  @JsonProperty(value = "eventId")
  private String eventId;

  @JsonProperty(value = "multicast")
  @Size(min = 1, max = 10)
  private Set<Transport> multicast;

  @JsonProperty(value = "referenceId")
  @JsonPropertyDescription(value = "reference id of the service etc. sending the notification")
  private String referenceId;

  @JsonProperty(value = "recepients")
  @Valid
  private List<BaseRecepientInfo> recepients;

  public String getEventId() {
    return eventId;
  }

  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public Set<Transport> getMulticast() {
    return multicast;
  }

  public void setMulticast(Set<Transport> multicast) {
    this.multicast = multicast;
  }

  public String getReferenceId() {
    return referenceId;
  }

  public void setReferenceId(String referenceId) {
    this.referenceId = referenceId;
  }

  public List<BaseRecepientInfo> getRecepients() {
    return recepients;
  }

  public void setRecepients(List<BaseRecepientInfo> recepients) {
    this.recepients = recepients;
  }

}
