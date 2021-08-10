package com.thrtec.events.eventsservice.helper;

import com.thrtec.events.eventsservice.dto.pageable.EventPageRequestDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaginationHelper {

    public Pageable createPageable(EventPageRequestDto eventPageRequestDto) {
        return PageRequest.of(eventPageRequestDto.getPage(), eventPageRequestDto.getSize());
    }

}
