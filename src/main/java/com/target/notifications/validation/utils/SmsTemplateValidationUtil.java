package com.target.notifications.validation.utils;

import com.target.notification.utils.ExceptionUtil;
import com.target.notifications.enums.Transport;
import com.target.notifications.models.base.BaseEventInfo;
import com.target.notifications.models.sms.SmsEventInfo;
import com.target.notifications.resources.EventRequestResource;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SmsTemplateValidationUtil implements TemplateValidationUtil {

  private static final String LOCALE_FIELD = "LOCALE:";

  @Override
  public boolean validateTemplates(BaseEventInfo eventInfo) {
    SmsEventInfo smsEventInfo = (SmsEventInfo) eventInfo;

    if (smsEventInfo.getTemplates() == null && smsEventInfo.getDefaultLocale() == null) {
      return true;
    } else if (smsEventInfo.getDefaultLocale() != null && (smsEventInfo.getTemplates() == null
        || !smsEventInfo.getTemplates().containsKey(smsEventInfo.getDefaultLocale()))) {
      ExceptionUtil.throwInvalidFieldException(EventRequestResource.class.getSimpleName(), "TEMPLATE:",
          "Missing template for default locale");
    }
    Map<String, String> fieldToErrorMsgMap = new HashMap<>();
    smsEventInfo.getTemplates().entrySet().forEach(entry -> {
      if (StringUtils.isBlank(entry.getKey().getLanguage())
          || !Arrays.stream(Locale.getAvailableLocales()).anyMatch(locale -> entry.getKey().equals(locale))) {
        fieldToErrorMsgMap.put(LOCALE_FIELD + entry.getKey(), "Locale is either empty or incorrect");
      }
    });
    ExceptionUtil.throwInvalidFieldException(EventRequestResource.class.getSimpleName(), fieldToErrorMsgMap);
    return true;

  }

  @Override
  public Transport getEventChannel() {
    return Transport.SMS;
  }

}
