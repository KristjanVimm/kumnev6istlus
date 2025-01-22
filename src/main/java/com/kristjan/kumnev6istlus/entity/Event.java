package com.kristjan.kumnev6istlus.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Event {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long eventId;
    private String eventName;
    private boolean isTimeMeasurement;

    public Event(Long eventId, String eventName, boolean isTimeMeasurement) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.isTimeMeasurement = isTimeMeasurement;
    }

    public Event(String eventName, boolean isTimeMeasurement) {
        this.eventName = eventName;
        this.isTimeMeasurement = isTimeMeasurement;
    }

    public Event() {
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public boolean isTimeMeasurement() {
        return isTimeMeasurement;
    }

    public void setTimeMeasurement(boolean timeMeasurement) {
        isTimeMeasurement = timeMeasurement;
    }
}
