package com.thrtec.events.eventsservice.dto.pageable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventPageRequestDto {
    private int page;
    private int size;
}
