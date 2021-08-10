package com.thrtec.events.eventsservice.service.getevent;

import com.thrtec.events.eventsservice.domain.Event;
import com.thrtec.events.eventsservice.dto.getevent.GetEventResponseDto;
import com.thrtec.events.eventsservice.dto.pageable.EventPageRequestDto;
import com.thrtec.events.eventsservice.helper.PaginationHelper;
import com.thrtec.events.eventsservice.mapper.EventMapper;
import com.thrtec.events.eventsservice.repository.MongoEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetEventServiceImpl implements GetEventService {

    private final MongoEventRepository mongoEventRepository;
    private final EventMapper eventMapper;
    private final PaginationHelper paginationHelper;

    @Override
    public Page<GetEventResponseDto> getEvents(EventPageRequestDto requestDto) {
        final Pageable pagination = paginationHelper.createPageable(requestDto);
        final Page<Event> events = mongoEventRepository.findAll(pagination);

        return eventMapper.toPageGetEventResponseDto(events);
    }

}
