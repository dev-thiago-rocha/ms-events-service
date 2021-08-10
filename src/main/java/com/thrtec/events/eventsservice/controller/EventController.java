package com.thrtec.events.eventsservice.controller;

import com.thrtec.events.eventsservice.dto.createevent.CreateEventRequestDto;
import com.thrtec.events.eventsservice.dto.createevent.CreateEventResponseDto;
import com.thrtec.events.eventsservice.dto.getevent.GetEventResponseDto;
import com.thrtec.events.eventsservice.dto.pageable.EventPageRequestDto;
import com.thrtec.events.eventsservice.service.createevent.CreateEventService;
import com.thrtec.events.eventsservice.service.getevent.GetEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {

    private final CreateEventService createEventService;
    private final GetEventService getEventService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateEventResponseDto createEvent(@Valid @RequestBody CreateEventRequestDto requestDto) {
        return createEventService.createEvent(requestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<GetEventResponseDto> getEvents(EventPageRequestDto requestDto) {
        return getEventService.getEvents(requestDto);
    }
}
