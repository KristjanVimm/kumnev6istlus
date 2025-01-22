package com.kristjan.kumnev6istlus.controller;

import com.kristjan.kumnev6istlus.entity.Athlete;
import com.kristjan.kumnev6istlus.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class AthleteController {

    @Autowired
    AthleteRepository athleteRepository;

    @GetMapping("athletes")
    public List<Athlete> getAthletes() {
        return athleteRepository.findAll();
    }

    @GetMapping("public-athletes")
    public Page<Athlete> getPublicAthletes(Pageable pageable) {
        return athleteRepository.findByOrderByAthleteIdAsc(pageable);
    }

    @PostMapping("athletes")
    public List<Athlete> addAthlete(@RequestBody Athlete athlete) {
        athleteRepository.save(athlete);
        return athleteRepository.findAll();
    }

    @DeleteMapping("athletes")
    public List<Athlete> deleteAthlete(@RequestParam Long athleteId) {
        athleteRepository.deleteById(athleteId);
        return athleteRepository.findAll();
    }

}
