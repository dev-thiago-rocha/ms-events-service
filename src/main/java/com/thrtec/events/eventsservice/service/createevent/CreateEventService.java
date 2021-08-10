package com.thrtec.events.eventsservice.service.createevent;

import com.thrtec.events.eventsservice.dto.createevent.CreateEventRequestDto;
import com.thrtec.events.eventsservice.dto.createevent.CreateEventResponseDto;

public interface CreateEventService {

    CreateEventResponseDto createEvent(CreateEventRequestDto requestDto);

}
