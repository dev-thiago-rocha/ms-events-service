package com.thrtec.events.eventsservice.service.getevent;

import com.thrtec.events.eventsservice.dto.getevent.GetEventResponseDto;
import com.thrtec.events.eventsservice.dto.pageable.EventPageRequestDto;
import org.springframework.data.domain.Page;

public interface GetEventService {

    Page<GetEventResponseDto> getEvents(EventPageRequestDto requestDto);

}
