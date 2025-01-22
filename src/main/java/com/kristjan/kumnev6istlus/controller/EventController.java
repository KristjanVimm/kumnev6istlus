package com.kristjan.kumnev6istlus.controller;

import com.kristjan.kumnev6istlus.entity.Event;
import com.kristjan.kumnev6istlus.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @GetMapping("events")
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @PostMapping("events")
    public List<Event> addEvents() {

        com.kristjan.kumnev6istlus.entity.Event[] events = {
                new Event(1L,"100 metres", true),
                new Event(2L,"discus throw", false),
                new Event(3L,"pole vault", false),
                new Event(4L,"javelin throw", false),
                new Event(5L,"400 metres", true),
                new Event(6L,"100 metres hurdles", true),
                new Event(7L,"long jump", false),
                new Event(8L,"shot put", false),
                new Event(9L,"high jump", false),
                new Event(10L,"1500 metres", true),
        };

        List<Event> eventsList = Arrays.asList(events);
        eventRepository.saveAll(eventsList);
        return eventsList;

    }

}
