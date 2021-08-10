package com.thrtec.events.eventsservice.controller;

import com.thrtec.events.eventsservice.dto.createevent.CreateEventRequestDto;
import com.thrtec.events.eventsservice.dto.createevent.CreateEventResponseDto;
import com.thrtec.events.eventsservice.dto.getevent.GetEventResponseDto;
import com.thrtec.events.eventsservice.dto.pageable.EventPageRequestDto;
import com.thrtec.events.eventsservice.enumerated.EventStatusType;
import com.thrtec.events.eventsservice.service.createevent.CreateEventService;
import com.thrtec.events.eventsservice.service.getevent.GetEventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class EventControllerTest {

    @InjectMocks
    private EventController eventController;

    @Mock
    private CreateEventService createEventService;

    @Mock
    private GetEventService getEventService;

    @Test
    void createEvent_withSuccess() {
        // Arrange
        final var requestDto = CreateEventRequestDto.builder()
                .userId(1L)
                .type("LIST_MESSAGES")
                .build();
        final var expected = CreateEventResponseDto.builder()
                .id("124")
                .status(EventStatusType.CREATED)
                .build();

        when(createEventService.createEvent(requestDto)).thenReturn(expected);

        // Act
        final CreateEventResponseDto actual = eventController.createEvent(requestDto);

        // Assert
        verify(createEventService).createEvent(requestDto);
        assertEquals(expected, actual);
    }

    @Test
    void getEvents_withSuccess() {
        // Arrange
        final var requestDto = EventPageRequestDto.builder()
                .page(1)
                .size(10)
                .build();
        final var expected = new PageImpl<>(Collections.singletonList(new GetEventResponseDto()));

        when(getEventService.getEvents(requestDto)).thenReturn(expected);

        // Act
        final Page<GetEventResponseDto> actual = eventController.getEvents(requestDto);

        // Assert
        verify(getEventService).getEvents(requestDto);
        assertEquals(expected, actual);
    }
}