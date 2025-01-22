package com.kristjan.kumnev6istlus.entity;

import jakarta.persistence.*;

@Entity
public class Outcome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long outcomeId;
    private Long athleteId;
    private Long eventId;
    private float outcome;

    public Outcome() {
    }

    public Outcome(Long outcomeId, Long athleteId, Long eventId, float outcome) {
        this.outcomeId = outcomeId;
        this.athleteId = athleteId;
        this.eventId = eventId;
        this.outcome = outcome;
    }

    public Outcome(Long athleteId, Long eventId, float outcome) {
        this.athleteId = athleteId;
        this.eventId = eventId;
        this.outcome = outcome;
    }

    public Long getOutcomeId() {
        return outcomeId;
    }

    public void setOutcomeId(Long outcomeId) {
        this.outcomeId = outcomeId;
    }

    public Long getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(Long athleteId) {
        this.athleteId = athleteId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public float getOutcome() {
        return outcome;
    }

    public void setOutcome(float outcome) {
        this.outcome = outcome;
    }
}