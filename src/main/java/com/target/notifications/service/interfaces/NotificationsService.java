package com.target.notifications.service.interfaces;

import com.target.notifications.dtos.NotificationsDto;

/**
 * This services is used to perform notifications
 * 
 * @author vinaymajety
 *
 */
public interface NotificationsService {


  /**
   * This method notifies the respective channels.
   * 
   * @param notificationDto
   * @return NotificationsDto
   */
  public NotificationsDto sendNotification(NotificationsDto notificationDto);
}
