package com.target.notifications.rest.controllers;

import com.target.notification.utils.ExceptionUtil;
import com.target.notifications.assemblers.NotificationsAssembler;
import com.target.notifications.dtos.NotificationsDto;
import com.target.notifications.exceptions.InvalidFieldException;
import com.target.notifications.resources.NotificationsRequestResource;
import com.target.notifications.resources.NotificationsResponseResource;
import com.target.notifications.service.interfaces.NotificationsService;
import com.target.notifications.validation.utils.NotificationsValidationUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * This class is used to perform notifications.
 * 
 * @author vinaymajety
 *
 */
@RestController
@RequestMapping("notifications")
public class NotificationsController {

  private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsController.class);

  private final NotificationsService notificationsService;

  private final NotificationsAssembler notificationsAssembler;

  private final NotificationsValidationUtil notificationsValidationUtil;



  @Autowired
  public NotificationsController(@NotNull NotificationsService NotificationsService,
      @NotNull NotificationsAssembler NotificationsAssembler,
      @NotNull NotificationsValidationUtil notificationsValidationUtil) {
    this.notificationsService = NotificationsService;
    this.notificationsAssembler = NotificationsAssembler;
    this.notificationsValidationUtil = notificationsValidationUtil;
  }
    

  /**
   * Sends notification.
   *
   * @param notificationRequest notificationRequest
   */
  @RequestMapping(method = RequestMethod.POST)
  @ApiOperation(value = "Send notification with given details")
  public ResponseEntity<NotificationsResponseResource> sendNotification(@ApiParam(value = "Send notification",
      required = true) @Valid @RequestBody NotificationsRequestResource notificationRequest) {
    try {
      notificationsValidationUtil.validateNotification(notificationRequest);
      NotificationsDto notificationDto = notificationsAssembler.getNotificationsDto(notificationRequest);
      NotificationsDto responseDto = notificationsService.sendNotification(notificationDto);
      LOGGER.info("created notification with id: {}", responseDto.getNotificationId());
      NotificationsResponseResource response = notificationsAssembler.toResponse(responseDto);
      return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    } catch (InvalidFieldException ex) {
      LOGGER.error("Invalid fields passed", ex);
      throw ex;
    } catch (Exception ex) {
      LOGGER.error("Exception while sending notification request", ex);
      throw ExceptionUtil.internalErrorException("Error while sending notification", ex);
    }
  }

}
