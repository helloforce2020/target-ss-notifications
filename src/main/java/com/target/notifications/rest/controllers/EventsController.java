package com.target.notifications.rest.controllers;

import com.target.notification.utils.ExceptionUtil;
import com.target.notifications.assemblers.EventsAssembler;
import com.target.notifications.dtos.EventsDto;
import com.target.notifications.exceptions.BadRequestException;
import com.target.notifications.exceptions.InvalidFieldException;
import com.target.notifications.resources.EventRequestResource;
import com.target.notifications.resources.EventResponseResource;
import com.target.notifications.service.interfaces.EventsService;
import com.target.notifications.validation.utils.EventValidationUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * The class is an entry point for various operations over Events.
 * 
 * @author vinaymajety
 *
 */
@RestController
@RequestMapping("notifications/events")
public class EventsController {

  private static final Logger LOGGER = LoggerFactory.getLogger(EventsController.class);

  private final EventsService eventsService;

  private final EventsAssembler eventsAssembler;

  private final EventValidationUtil validationUtil;

  private static final String ERROR_CREATING_EVENT = "Error while creating event";


  @Autowired
  public EventsController(@NotNull EventsService eventsService,
      @NotNull EventsAssembler eventsAssembler, @NotNull EventValidationUtil validationUtil) {
    this.eventsService = eventsService;
    this.eventsAssembler = eventsAssembler;
    this.validationUtil = validationUtil;
  }
    
  /**
   * API for event creation.
   * 
   * @param auth auth
   * @param eventCreationRequest eventCreationRequest
   * @return eventCreationResponse eventCreationResponse
   */
  @RequestMapping(method = RequestMethod.POST)
  @ApiOperation(value = "Create event with given details")
  public ResponseEntity<EventResponseResource> createEvent(
      @RequestHeader(value = "Authorization", required = true) String auth,
      @ApiParam(value = "Create an event with given name and parameters",
          required = true) @Valid @RequestBody EventRequestResource eventCreationRequest) {
    try {
      validationUtil.validateCreateEvent(eventCreationRequest);
      EventsDto eventDto = eventsAssembler.getEventDto(eventCreationRequest);
      EventsDto createEvent = eventsService.createEvent(eventDto);
      LOGGER.info("created event with id: {}, name: {}", createEvent.getId(), createEvent.getName());
      EventResponseResource responseResource = eventsAssembler.geteventResponseResource(createEvent);
      return new ResponseEntity<>(responseResource, HttpStatus.OK);
    } catch (InvalidFieldException ex) {
      LOGGER.error("Field error in event creation request", ex);
      throw ex;
    } catch (BadRequestException ex) {
      LOGGER.error(ERROR_CREATING_EVENT, ex);
      throw ExceptionUtil.badRequestException(ERROR_CREATING_EVENT, ex);
    } catch (Exception ex) {
      LOGGER.error(ERROR_CREATING_EVENT, ex);
      throw ExceptionUtil.internalErrorException(ERROR_CREATING_EVENT, ex);
    }
  }

}
