package com.target.notifications.validation.utils;

import com.target.notification.utils.ExceptionUtil;
import com.target.notifications.models.EventSearchParams;
import com.target.notifications.resources.NotificationsRequestResource;
import com.target.notifications.service.interfaces.EventsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationsValidationUtil {


  @Autowired
  private EventsService eventService;

  public void validateNotification(NotificationsRequestResource eventRequestResource) {

    EventSearchParams searchparams = new EventSearchParams();
    searchparams.setId(eventRequestResource.getEventId());
    if (eventService.searchEvent(searchparams) == null) {
      ExceptionUtil.throwInvalidFieldException("event", "event", "eventName doesnt exist");
    }
    // code to validate for mandatory fields
    // validate for multicast
    // validate recepient objects
  }
}
