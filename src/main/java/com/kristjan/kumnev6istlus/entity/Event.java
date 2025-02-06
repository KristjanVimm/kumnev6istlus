package com.kristjan.kumnev6istlus.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    private Long eventId;
    private String eventName;
    private boolean isTimeMeasurement;

    public Event(String eventName, boolean isTimeMeasurement) {
        this.eventName = eventName;
        this.isTimeMeasurement = isTimeMeasurement;
    }

}
