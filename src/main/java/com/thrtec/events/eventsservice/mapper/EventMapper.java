package com.thrtec.events.eventsservice.mapper;

import com.thrtec.events.eventsservice.domain.Event;
import com.thrtec.events.eventsservice.dto.createevent.CreateEventRequestDto;
import com.thrtec.events.eventsservice.dto.createevent.CreateEventResponseDto;
import com.thrtec.events.eventsservice.dto.getevent.GetEventResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EventMapper {

    public Event toEvent(CreateEventRequestDto requestDto) {
        return Event.builder()
                .type(requestDto.getType())
                .userId(requestDto.getUserId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public CreateEventResponseDto toCreateEventResponseDto(Event event) {
        return CreateEventResponseDto.builder()
                .id(event.getId())
                .status(event.getStatus())
                .build();
    }

    public Page<GetEventResponseDto> toPageGetEventResponseDto(Page<Event> events) {
        return events.map(this::toGetEventResponseDto);
    }

    private GetEventResponseDto toGetEventResponseDto(Event event) {
        return GetEventResponseDto.builder()
                .id(event.getId())
                .createdAt(event.getCreatedAt())
                .status(event.getStatus())
                .type(event.getType())
                .userId(event.getUserId())
                .build();
    }

}
