package com.thrtec.events.eventsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class EventsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventsServiceApplication.class, args);
    }

}
