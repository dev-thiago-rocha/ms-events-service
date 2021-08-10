package com.thrtec.events.eventsservice.service.createevent;

import com.thrtec.events.eventsservice.dto.createevent.CreateEventRequestDto;
import com.thrtec.events.eventsservice.dto.createevent.CreateEventResponseDto;
import com.thrtec.events.eventsservice.enumerated.EventStatusType;
import com.thrtec.events.eventsservice.mapper.EventMapper;
import com.thrtec.events.eventsservice.repository.MongoEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateEventServiceImpl implements CreateEventService {

    private final EventMapper eventMapper;
    private final MongoEventRepository mongoEventRepository;

    @Override
    public CreateEventResponseDto createEvent(final CreateEventRequestDto requestDto) {
        var event = eventMapper.toEvent(requestDto);

        event.setStatus(EventStatusType.CREATED);
        event = mongoEventRepository.save(event);

        return eventMapper.toCreateEventResponseDto(event);
    }

}
