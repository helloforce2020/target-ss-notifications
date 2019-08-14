package com.target.notifications.validation.utils;

import com.target.notification.utils.ExceptionUtil;
import com.target.notifications.enums.Transport;
import com.target.notifications.models.base.BaseEventInfo;
import com.target.notifications.models.email.EmailEventInfo;
import com.target.notifications.resources.EventRequestResource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component
public class EmailTemplateValidationUtil implements TemplateValidationUtil {

  private static final String LOCALE_FIELD = "LOCALE:";

  @Override
  public boolean validateTemplates(BaseEventInfo eventInfo) {
    EmailEventInfo emailEventInfo = (EmailEventInfo) eventInfo;

    if (emailEventInfo.getTemplates() == null && emailEventInfo.getDefaultLocale() == null) {
      return true;
    } else if (emailEventInfo.getDefaultLocale() != null && (emailEventInfo.getTemplates() == null
        || !emailEventInfo.getTemplates().containsKey(emailEventInfo.getDefaultLocale()))) {
      ExceptionUtil.throwInvalidFieldException(EventRequestResource.class.getSimpleName(), "TEMPLATE:",
          "Missing template for default locale");
    }
    Map<String, String> fieldToErrorMsgMap = new HashMap<>();
    emailEventInfo.getTemplates().entrySet().forEach(entry -> {
      if (StringUtils.isBlank(entry.getKey().getLanguage())
          || Arrays.stream(Locale.getAvailableLocales()).noneMatch(locale -> entry.getKey().equals(locale))) {
        fieldToErrorMsgMap.put(LOCALE_FIELD + entry.getKey(), "Locale is either empty or incorrect");
      }
      if (StringUtils.isBlank(entry.getValue().getSubject())) {
        fieldToErrorMsgMap.put("emailEventInfo.templates[" + entry.getKey() + "].subject", "may not be empty");
      }
    });
    ExceptionUtil.throwInvalidFieldException(EventRequestResource.class.getSimpleName(), fieldToErrorMsgMap);
    return true;

  }

  @Override
  public Transport getEventChannel() {
    return Transport.EMAIL;
  }

}
