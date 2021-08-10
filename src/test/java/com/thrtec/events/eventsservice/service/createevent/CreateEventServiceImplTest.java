package com.thrtec.events.eventsservice.service.createevent;

import com.thrtec.events.eventsservice.domain.Event;
import com.thrtec.events.eventsservice.dto.createevent.CreateEventRequestDto;
import com.thrtec.events.eventsservice.dto.createevent.CreateEventResponseDto;
import com.thrtec.events.eventsservice.enumerated.EventStatusType;
import com.thrtec.events.eventsservice.mapper.EventMapper;
import com.thrtec.events.eventsservice.repository.MongoEventRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class CreateEventServiceImplTest {

    @InjectMocks
    private CreateEventServiceImpl createEventService;

    @Mock
    private EventMapper eventMapper;

    @Mock
    private MongoEventRepository mongoEventRepository;

    @Test
    void createEvent_withSuccess() {
        // Arrange
        final var requestDto = CreateEventRequestDto.builder()
                .userId(1L)
                .type("TYPE")
                .build();
        final var event = Event.builder()
                .id("1")
                .createdAt(LocalDateTime.now())
                .type(requestDto.getType())
                .userId(requestDto.getUserId())
                .status(EventStatusType.CREATED)
                .build();
        final var expected = CreateEventResponseDto.builder()
                .status(EventStatusType.CREATED)
                .id("1")
                .build();

        when(eventMapper.toEvent(requestDto)).thenReturn(event);
        when(mongoEventRepository.save(event)).thenReturn(event);
        when(eventMapper.toCreateEventResponseDto(event)).thenReturn(expected);

        // Act
        final CreateEventResponseDto actual = createEventService.createEvent(requestDto);

        // Assert
        verify(eventMapper).toEvent(requestDto);
        verify(mongoEventRepository).save(event);
        verify(eventMapper).toCreateEventResponseDto(event);
        assertEquals(expected, actual);
    }
}