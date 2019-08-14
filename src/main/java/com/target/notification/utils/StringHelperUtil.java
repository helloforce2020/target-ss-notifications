package com.target.notification.utils;

import com.target.notifications.enums.Transport;
import com.target.notifications.models.base.BaseTemplate;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Utility to perform string manipulation operations.
 * 
 * @author vinaymajety
 *
 */
public final class StringHelperUtil {

  private static final String CONTENT_VARIABLE = ":content";

  /**
   * Default Constructor.
   */
  private StringHelperUtil() {
  }

  /**
   * Extracts context variable names from given template string.
   * 
   * @param content content of the message
   * @return list of custom variables defined in the message
   */
  public static List<String> getContextVariables(String content, Transport transport,
      Locale locale) {
    String errorField = transport + ":" + locale + CONTENT_VARIABLE;
    if (StringUtils.isBlank(content)) {
      ExceptionUtil.throwInvalidFieldException(BaseTemplate.class.getSimpleName(), errorField,
          "Message template is null or empty");
    }
    List<String> variables = new ArrayList<>();
    int start = 0;
    final String startPattern = "{{";
    final String endPattern = "}}";
    start = content.indexOf(startPattern, start);
    while (start != -1) {
      int end = content.indexOf(endPattern, start);
      if (end == -1) {
        ExceptionUtil.throwInvalidFieldException(BaseTemplate.class.getSimpleName(), errorField,
            "Message template has invalid custom variable creation");
      } else if (end < start + 3) {
        ExceptionUtil.throwInvalidFieldException(BaseTemplate.class.getSimpleName(), errorField,
            "Unallowed variable name in template");
      }
      String variable = content.substring(start + startPattern.length(), end);
      if (!variables.contains(variable)) {
        variables.add(variable);
      }
      start = content.indexOf(startPattern, end);
    }
    return variables;
  }
}
