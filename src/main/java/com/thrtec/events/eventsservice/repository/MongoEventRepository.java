package com.thrtec.events.eventsservice.repository;

import com.thrtec.events.eventsservice.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoEventRepository extends MongoRepository<Event, String> {
}
