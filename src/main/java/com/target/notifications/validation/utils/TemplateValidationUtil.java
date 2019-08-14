package com.target.notifications.validation.utils;

import com.target.notifications.enums.Transport;
import com.target.notifications.models.base.BaseEventInfo;

public interface TemplateValidationUtil {

  public boolean validateTemplates(BaseEventInfo smsEventInfo);

  public Transport getEventChannel();
}
