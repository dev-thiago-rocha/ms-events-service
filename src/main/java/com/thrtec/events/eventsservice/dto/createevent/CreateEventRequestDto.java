package com.thrtec.events.eventsservice.dto.createevent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateEventRequestDto {

    @NotBlank
    private String type;

    @NotNull
    private Long userId;

}
