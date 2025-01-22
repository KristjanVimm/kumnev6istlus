package com.kristjan.kumnev6istlus.repository;

import com.kristjan.kumnev6istlus.entity.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OutcomeRepository extends JpaRepository<Outcome, Long> {

    @Query("SELECT outcome FROM Outcome AS o WHERE o.eventId = :eventId AND o.athleteId = :athleteId")
    Float getOutcome(@Param("eventId") Long eventId, @Param("athleteId") Long athleteId);



    @Query("SELECT athleteId FROM Outcome")
    List<Long> findAthleteIds();

    @Query("SELECT eventId FROM Outcome")
    List<Long> findEventIds();

    @Query("select o from Outcome o where o.eventId = ?1 and o.athleteId = ?2")
    Outcome findByEventIdAndAthleteId(Long eventId, Long athleteId);
}
