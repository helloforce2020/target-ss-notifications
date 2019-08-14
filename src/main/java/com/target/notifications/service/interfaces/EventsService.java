package com.target.notifications.service.interfaces;

import com.target.notifications.dtos.EventsDto;
import com.target.notifications.models.EventSearchParams;

/**
 * This is the core service that performs various operations on events.
 * 
 * @author vinaymajety
 *
 */
public interface EventsService {

  /**
   * Fetch event by name and business unit.
   * 
   * @param name
   * @param businessUnit
   * @return EventsDto
   */
  public EventsDto getEventByNameAndBusinessUnit(String name, String businessUnit);

  /**
   * Search events.
   * 
   * @param searchparams
   * @return EventsDto
   */
  public EventsDto searchEvent(EventSearchParams searchparams);

  /**
   * Create event.
   * 
   * @param eventDto
   * @return EventsDto
   */
  public EventsDto createEvent(EventsDto eventDto);
}
