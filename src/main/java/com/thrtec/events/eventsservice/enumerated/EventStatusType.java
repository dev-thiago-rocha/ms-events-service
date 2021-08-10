package com.thrtec.events.eventsservice.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EventStatusType {

    CREATED("O evento foi criado com sucesso!"),
    ERROR("Ocorreu um erro inesperado na criacao do evento");

    private String message;
}
