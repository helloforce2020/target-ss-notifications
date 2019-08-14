package com.target.notifications.assemblers;

import com.target.notifications.dtos.NotificationsDto;
import com.target.notifications.resources.NotificationsRequestResource;
import com.target.notifications.resources.NotificationsResponseResource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * Assembler for notifications.
 * 
 * @author vinaymajety
 *
 */
@Component
public class NotificationsAssembler {

  /**
   * Converts eventCreationRequset to eventDto.
   * 
   * @param eventCreationRequest eventCreationRequest
   * @return eventDto eventDto
   */
  public NotificationsDto getNotificationsDto(@NotNull NotificationsRequestResource notificationsRequestResource) {
    NotificationsDto notificationsDto = new NotificationsDto();

    BeanUtils.copyProperties(notificationsRequestResource, notificationsDto);
    // set timestamp field here
    return notificationsDto;
  }

  /**
   * Converts DTO to Response.
   * 
   * @param notificationsDto
   */
  public NotificationsResponseResource toResponse(NotificationsDto notificationsDto) {
    NotificationsResponseResource resource = new NotificationsResponseResource();
    resource.setNotificationId(notificationsDto.getNotificationId());
    return resource;
  }


}
