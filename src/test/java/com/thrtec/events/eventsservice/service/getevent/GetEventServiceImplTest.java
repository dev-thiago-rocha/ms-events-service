package com.thrtec.events.eventsservice.service.getevent;

import com.thrtec.events.eventsservice.domain.Event;
import com.thrtec.events.eventsservice.dto.getevent.GetEventResponseDto;
import com.thrtec.events.eventsservice.dto.pageable.EventPageRequestDto;
import com.thrtec.events.eventsservice.enumerated.EventStatusType;
import com.thrtec.events.eventsservice.helper.PaginationHelper;
import com.thrtec.events.eventsservice.mapper.EventMapper;
import com.thrtec.events.eventsservice.repository.MongoEventRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class GetEventServiceImplTest {

    @InjectMocks
    private GetEventServiceImpl getEventService;

    @Mock
    private MongoEventRepository mongoEventRepository;

    @Mock
    private EventMapper eventMapper;

    @Mock
    private PaginationHelper paginationHelper;

    @Test
    void getEvents_withSuccess() {
        // Arrange
        final var requestDto = EventPageRequestDto.builder()
                .size(10)
                .page(1)
                .build();
        final var pageable = paginationHelper.createPageable(requestDto);
        final var event = Event.builder()
                .id("1")
                .createdAt(LocalDateTime.now())
                .type("TYPE")
                .userId(2L)
                .status(EventStatusType.CREATED)
                .build();
        final var responseDto = GetEventResponseDto.builder()
                .id(event.getId())
                .createdAt(event.getCreatedAt())
                .status(event.getStatus())
                .type(event.getType())
                .userId(event.getUserId())
                .build();
        final Page<Event> pageEvent = new PageImpl<>(Collections.singletonList(event));
        final Page<GetEventResponseDto> expected = new PageImpl<>(Collections.singletonList(responseDto));

        when(mongoEventRepository.findAll(pageable)).thenReturn(pageEvent);
        when(eventMapper.toPageGetEventResponseDto(pageEvent)).thenReturn(expected);

        // Act
        final Page<GetEventResponseDto> actual = getEventService.getEvents(requestDto);

        // Assert
        verify(mongoEventRepository).findAll(pageable);
        verify(eventMapper).toPageGetEventResponseDto(pageEvent);
        assertEquals(expected, actual);
    }
}