package com.kristjan.kumnev6istlus.repository;

import com.kristjan.kumnev6istlus.entity.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutcomeRepository extends JpaRepository<Outcome, Long> {

    Outcome findByEventIdAndAthleteId(Long eventId, Long athleteId);

}
