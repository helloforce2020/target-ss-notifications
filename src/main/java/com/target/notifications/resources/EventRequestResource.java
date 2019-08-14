package com.target.notifications.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.target.notifications.enums.EventType;
import com.target.notifications.enums.NotificationPriority;
import com.target.notifications.enums.Status;
import com.target.notifications.models.base.BaseEventInfo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Event creation request payload pojo.
 * 
 * @author vinaymajety
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventRequestResource {

  @JsonProperty(value = "name", required = true)
  @Pattern(regexp = "[A-Za-z0-9/_]*", message = "Event name can contain a-z,A-Z,0-9,/ and _.")
  private String name;

  @JsonProperty(value = "businessUnit", required = true)
  @Pattern(regexp = "[A-Za-z_]*", message = "Business unit must contain only alphabets.")
  private String businessUnit;

  @NotNull(message = "Invalid value, valid values are [TRANSACTIONAL, MARKETING, SERVICING]")
  private EventType type;

  @JsonProperty(value = "description")
  private String description;

  @JsonProperty("priority")
  private NotificationPriority priority;

  @JsonProperty("eventInfo")
  @NotNull(message = "EventInfo cannot be NULL")
  private List<BaseEventInfo> eventInfo;

  @JsonProperty(value = "status")
  @NotNull
  private Status status;

  public String getName() {
    return name;
  }

  public void setName(String eventName) {
    this.name = eventName;
  }

  public String getBusinessUnit() {
    return businessUnit;
  }

  public void setBusinessUnit(String businessUnit) {
    this.businessUnit = businessUnit;
  }

  public EventType getType() {
    return type;
  }

  public void setType(EventType eventType) {
    this.type = eventType;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public NotificationPriority getPriority() {
    return priority;
  }

  public void setPriority(NotificationPriority priority) {
    this.priority = priority;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public List<BaseEventInfo> getEventInfo() {
    return eventInfo;
  }

  public void setEventInfo(List<BaseEventInfo> eventsInfo) {
    this.eventInfo = eventsInfo;
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
