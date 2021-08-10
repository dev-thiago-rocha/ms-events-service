package com.thrtec.events.eventsservice.dto.createevent;

import com.thrtec.events.eventsservice.enumerated.EventStatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateEventResponseDto {

    private String id;
    private EventStatusType status;

}
