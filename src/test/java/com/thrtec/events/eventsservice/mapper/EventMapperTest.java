package com.thrtec.events.eventsservice.mapper;

import com.thrtec.events.eventsservice.domain.Event;
import com.thrtec.events.eventsservice.dto.createevent.CreateEventRequestDto;
import com.thrtec.events.eventsservice.dto.createevent.CreateEventResponseDto;
import com.thrtec.events.eventsservice.dto.getevent.GetEventResponseDto;
import com.thrtec.events.eventsservice.enumerated.EventStatusType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({MockitoExtension.class})
class EventMapperTest {

    @InjectMocks
    private EventMapper eventMapper;

    @Test
    void toEvent_withSuccess() {
        // Arrange
        final var requestDto = CreateEventRequestDto.builder()
                .type("TYPE")
                .userId(1L)
                .build();
        final var expected = Event.builder()
                .createdAt(LocalDateTime.now())
                .userId(requestDto.getUserId())
                .type(requestDto.getType())
                .build();

        // Act
        final Event actual = eventMapper.toEvent(requestDto);

        // Assert
        assertThat(actual).usingRecursiveComparison().ignoringFields("createdAt").isEqualTo(expected);
        assertThat(actual.getCreatedAt()).isEqualToIgnoringNanos(expected.getCreatedAt());
    }

    @Test
    void toCreateEventResponseDto_withSuccess() {
        // Arrange
        final var event = Event.builder()
                .id("1")
                .status(EventStatusType.CREATED)
                .createdAt(LocalDateTime.now())
                .type("TYPE")
                .userId(2L)
                .build();
        final var expected = CreateEventResponseDto.builder()
                .id(event.getId())
                .status(event.getStatus())
                .build();

        // Act
        final CreateEventResponseDto actual = eventMapper.toCreateEventResponseDto(event);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void toPageGetEventResponseDto_withSuccess() {
        // Arrange
        final var event = Event.builder()
                .id("1")
                .status(EventStatusType.CREATED)
                .createdAt(LocalDateTime.now())
                .type("TYPE")
                .userId(2L)
                .build();
        final var getEventResponseDto = GetEventResponseDto.builder()
                .userId(event.getUserId())
                .id(event.getId())
                .type(event.getType())
                .status(event.getStatus())
                .createdAt(event.getCreatedAt())
                .build();
        final var events = Collections.singletonList(event);
        final Page<Event> eventsPage = new PageImpl<>(events);
        final var responses = Collections.singletonList(getEventResponseDto);
        final var responsesPage = new PageImpl<>(responses);

        // Act
        final Page<GetEventResponseDto> actual = eventMapper.toPageGetEventResponseDto(eventsPage);

        // Assert
        assertEquals(responsesPage, actual);
    }
}