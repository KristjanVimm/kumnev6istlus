package com.kristjan.kumnev6istlus.repository;

import com.kristjan.kumnev6istlus.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT eventId FROM Event")
    List<Long> findEventIds();

}
