package com.target.notifications.validation.utils;

import com.target.notifications.enums.Transport;
import com.target.notifications.models.base.BaseEventInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TemplateValidator {

  @Autowired
  private List<TemplateValidationUtil> templateValidationUtils;

  private Map<Transport, TemplateValidationUtil> templateValidatorsMap = new HashMap<>();
  
  public TemplateValidator() {
    for (TemplateValidationUtil validationUtil : templateValidationUtils) {
      templateValidatorsMap.put(validationUtil.getEventChannel(), validationUtil);
    }
  }

  public boolean validateTemplates(List<BaseEventInfo> eventInfo) {
    List<BaseEventInfo> eventToValidate = eventInfo == null ? new ArrayList<>() : eventInfo;
    boolean isValid = true;
    for (BaseEventInfo baseEventInfo : eventToValidate) {
      isValid = (isValid && templateValidatorsMap.get(baseEventInfo.getTransport()).validateTemplates(baseEventInfo));
      if (!isValid) {
        return false;
      }
    }
    return true;
  }

  // List<BaseEventInfo> eventInfo

}
