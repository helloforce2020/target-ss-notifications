package com.target.notifications.enums;

/**
 * delivery status for a notification.
 * 
 * @author phanivempaty
 *
 */
public enum NotificationDeliveryStatus {
  WAITING(false),
  SENT_FOR_DELIVERY(false),
  FAILED_TO_SENT_FOR_DELIVERY(true),
  IN_PROGRESS(false),
  RETRY(false),
  FAILED(true),
  SUCCESS(true);

  private boolean shouldDeliverReport;

  NotificationDeliveryStatus(boolean shouldDeliverReport) {
    this.shouldDeliverReport = shouldDeliverReport;
  }

  public boolean isShouldDeliverReport() {
    return shouldDeliverReport;
  }

}