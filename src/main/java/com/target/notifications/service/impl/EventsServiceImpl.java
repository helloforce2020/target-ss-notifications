package com.target.notifications.service.impl;

import com.target.notifications.dtos.EventsDto;
import com.target.notifications.models.EventSearchParams;
import com.target.notifications.repository.EventRepository;
import com.target.notifications.service.interfaces.EventsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @inheritDoc
 *
 */
@Component
public class EventsServiceImpl implements EventsService {

  @Autowired
  private EventRepository eventRepository;

  /**
   * @inheritDoc
   *
   */
  @Override
  public EventsDto getEventByNameAndBusinessUnit(String name, String businessUnit) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * @inheritDoc
   *
   */
  @Override
  public EventsDto createEvent(EventsDto eventDto) {
    // write the parsing logic to identify variables in the DTO
    eventRepository.createEvent(eventDto);
    return null;
  }

  /**
   * @inheritDoc
   *
   */
  @Override
  public EventsDto searchEvent(EventSearchParams searchparams) {
    // TODO Auto-generated method stub
    return null;
  }

}
