package com.kristjan.kumnev6istlus.repository;

import com.kristjan.kumnev6istlus.entity.Athlete;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.List;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {

    @Query("SELECT athleteId FROM Athlete")
    List<Long> findAthleteIds();

    Page<Athlete> findByOrderByAthleteIdAsc(Pageable pageable);


}
