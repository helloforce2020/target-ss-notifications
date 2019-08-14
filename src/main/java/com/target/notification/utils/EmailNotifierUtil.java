package com.target.notification.utils;

import com.target.notifications.dtos.NotificationsDto;
import com.target.notifications.enums.Transport;
import com.target.notifications.models.base.BaseRecepientInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EmailNotifierUtil implements ChannelNotifierUtil {

  @Value(value = "target/notifications:emails")
  private String topicName; // this value can also be configured in properties file
  
  @Autowired
  private NotificationEventsProducer producer;

  /**
   * @inheritDoc
   *
   */
  @Override
  public void notify(BaseRecepientInfo recepientInfo, NotificationsDto notificationDto) {
    // fetch event created
    // logic to bind template with variables and create payload
    this.getEmailPayloadAsMap(recepientInfo, notificationDto);

  }

  private Map<String, Object> getEmailPayloadAsMap(BaseRecepientInfo recepientInfo, NotificationsDto notificationDto) {
    Map<String, Object> response = new HashMap<String, Object>();
    // stubbed method.. converter logic to be written here...
    producer.pushToStream(topicName, response);
    return response;
  }

  /**
   * @inheritDoc
   *
   */
  public Transport getChannel() {
    return Transport.EMAIL;
  }
}
