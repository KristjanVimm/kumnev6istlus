package com.kristjan.kumnev6istlus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Outcome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long outcomeId;
    private Long athleteId;
    private Long eventId;
    private float outcome;

    public Outcome(Long athleteId, Long eventId, float outcome) {
        this.athleteId = athleteId;
        this.eventId = eventId;
        this.outcome = outcome;
    }

}