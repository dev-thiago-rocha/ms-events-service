package com.thrtec.events.eventsservice.domain;

import com.thrtec.events.eventsservice.enumerated.EventStatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Document("events")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Event {

    @Id
    private String id;
    private String type;
    private Long userId;
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private EventStatusType status;

}
