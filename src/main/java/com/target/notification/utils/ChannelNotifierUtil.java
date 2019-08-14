package com.target.notification.utils;

import com.target.notifications.dtos.NotificationsDto;
import com.target.notifications.enums.Transport;
import com.target.notifications.models.base.BaseRecepientInfo;

/**
 * This notifier is a wrapper over various channels namely SMS, EMAIL. Notifies the corresposnind channel to perform the
 * necessary actions related to notifications.
 * 
 * @author vinaymajety
 *
 */
public interface ChannelNotifierUtil {

  /**
   * This method notifies the respective channel.
   * 
   * @param recepientInfo recepientInfo
   * @param notificationDto notificationDto
   */
  public void notify(BaseRecepientInfo recepientInfo, NotificationsDto notificationDto);

  /**
   * This method is used to register the channel with the notifier.
   * 
   * @return Transport
   */
  public Transport getChannel();
}
