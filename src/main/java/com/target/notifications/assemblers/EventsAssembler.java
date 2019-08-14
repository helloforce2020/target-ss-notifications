package com.target.notifications.assemblers;

import com.target.notifications.dtos.EventsDto;
import com.target.notifications.enums.EventType;
import com.target.notifications.enums.NotificationPriority;
import com.target.notifications.resources.EventRequestResource;
import com.target.notifications.resources.EventResponseResource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

import javax.validation.constraints.NotNull;

/**
 * Assembler for events.
 * 
 * @author vinaymajety
 *
 */
@Component
public class EventsAssembler {

  /**
   * Converts eventCreationRequset to eventDto.
   * 
   * @param eventCreationRequest eventCreationRequest
   * @return eventDto eventDto
   */
  public EventsDto getEventDto(@NotNull EventRequestResource eventCreationRequest) {
    EventsDto eventDto = new EventsDto();
    if (eventCreationRequest.getType() == null) {
      eventCreationRequest.setType(EventType.BATCH);
    }
    if (eventCreationRequest.getPriority() == null) {
      eventCreationRequest.setPriority(NotificationPriority.LOW);
    }
    BeanUtils.copyProperties(eventCreationRequest, eventDto);
    eventDto.setId(UUID.randomUUID().toString());
    return eventDto;
  }

  /**
   * This method converts Dto to resource.
   * 
   * @param eventsDto eventsDto
   * @return EventResponseResource
   */
  public EventResponseResource geteventResponseResource(EventsDto eventsDto) {
    EventResponseResource response = new EventResponseResource();
    BeanUtils.copyProperties(eventsDto, response);
    return response;
  }

}
