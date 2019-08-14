package com.target.notifications.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.target.notifications.enums.NotificationDeliveryStatus;
import com.target.notifications.enums.Transport;
import com.target.notifications.models.base.BaseRecepientInfo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;
import java.util.Set;

/**
 * DTO for Notifications.
 * 
 * @author vinaymajety
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationsDto {

  private String notificationId;
  
  private String eventId;

  private Set<Transport> multicast;

  private String referenceId;

  private List<BaseRecepientInfo> recepients;

  private String timestamp;

  private NotificationDeliveryStatus status;

  public String getNotificationId() {
    return notificationId;
  }

  public void setNotificationId(String notificationId) {
    this.notificationId = notificationId;
  }

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

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public NotificationDeliveryStatus getStatus() {
    return status;
  }

  public void setStatus(NotificationDeliveryStatus status) {
    this.status = status;
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public boolean equals(Object o) {
    return EqualsBuilder.reflectionEquals(this, o);
  }

}
