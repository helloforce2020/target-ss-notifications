package com.target.notifications.validation.utils;

import com.target.notification.utils.ExceptionUtil;
import com.target.notifications.resources.EventRequestResource;
import com.target.notifications.service.interfaces.EventsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventValidationUtil {

  @Autowired
  private TemplateValidator channelTemplateValidator;

  @Autowired
  private EventsService eventService;

  public boolean validateCreateEvent(EventRequestResource eventRequestResource) {
    if (eventService.getEventByNameAndBusinessUnit(eventRequestResource.getName(),
        eventRequestResource.getBusinessUnit()) != null) {
      ExceptionUtil.throwInvalidFieldException("event", "event", "eventName already exisits for the given tenant");
    }
    return channelTemplateValidator.validateTemplates(eventRequestResource.getEventInfo());
  }
}
