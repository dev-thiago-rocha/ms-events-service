package com.thrtec.events.eventsservice.dto.getevent;

import com.thrtec.events.eventsservice.enumerated.EventStatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetEventResponseDto {

    private String id;
    private String type;
    private Long userId;
    private EventStatusType status;
    private LocalDateTime createdAt;

}
