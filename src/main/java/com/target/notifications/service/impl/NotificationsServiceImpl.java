package com.target.notifications.service.impl;

import com.target.notification.utils.ChannelNotifierUtil;
import com.target.notifications.dtos.NotificationsDto;
import com.target.notifications.enums.NotificationDeliveryStatus;
import com.target.notifications.enums.Transport;
import com.target.notifications.models.base.BaseRecepientInfo;
import com.target.notifications.repository.NotificationsRepository;
import com.target.notifications.service.interfaces.NotificationsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @inheritDoc
 *
 */
@Component
public class NotificationsServiceImpl implements NotificationsService {

  @Autowired
  private List<ChannelNotifierUtil> notifiers;

  @Autowired
  private NotificationsRepository notificationsRepository;

  private Map<Transport, ChannelNotifierUtil> notifiersMap;

  public NotificationsServiceImpl() {
    notifiersMap = new HashMap<>();
    for (ChannelNotifierUtil notUtil : notifiers) {
      notifiersMap.put(notUtil.getChannel(), notUtil);
    }
  }

  /**
   * @inheritDoc
   *
   */
  @Override
  public NotificationsDto sendNotification(NotificationsDto notificationDto) {
    // perform validation to check if multicast and basereepientinfo match
    for (BaseRecepientInfo recepientInfo : notificationDto.getRecepients()) {
      notifiersMap.get(recepientInfo.getChannel()).notify(recepientInfo, notificationDto);
    }
    notificationDto.setNotificationId(UUID.randomUUID().toString());
    notificationDto.setStatus(NotificationDeliveryStatus.IN_PROGRESS);
    notificationsRepository.createNotification(notificationDto);
    return notificationDto;
  }


}
