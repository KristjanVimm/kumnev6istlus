package com.kristjan.kumnev6istlus.controller;

import com.kristjan.kumnev6istlus.entity.Athlete;
import com.kristjan.kumnev6istlus.entity.Outcome;
import com.kristjan.kumnev6istlus.repository.AthleteRepository;
import com.kristjan.kumnev6istlus.repository.OutcomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class OutcomeController {

    @Autowired
    OutcomeRepository outcomeRepository;
    @Autowired
    AthleteRepository athleteRepository;

    @GetMapping("outcomes")
    public List<Outcome> getOutcome() {
        return outcomeRepository.findAll();
    }

    @PostMapping("add-outcome")
    public List<Outcome> addOutcome(@RequestBody Outcome outcome) {
//        if (outcomeRepository.findAthleteIds().contains(outcome.getAthleteId()) &&
//            outcomeRepository.findEventIds().contains(outcome.getEventId())) {
//            throw new RuntimeException("This athlete and event pair is already filled");
//        }
        outcomeRepository.save(outcome);
        return outcomeRepository.findAll();
    }

    @PostMapping("add-outcome/{athleteId}/{eventId}/{outcomeNumber}")
    public List<Outcome> addOutcomeByIds(@PathVariable Long athleteId, @PathVariable Long eventId, @PathVariable float outcomeNumber) {
        Outcome outcome = new Outcome(athleteId, eventId, outcomeNumber);
        outcomeRepository.save(outcome);
        return outcomeRepository.findAll();
    }

    @GetMapping("athlete-score")
    public Float getAthleteScore(@RequestParam Long athleteId) {
        List<Float> outcomes = new ArrayList<>();
        for (long i = 1; i < 11; i++) {
            try {
//                float outcome = outcomeRepository.getOutcome((long) i, athleteId);
                Outcome outcomeObject = outcomeRepository.findByEventIdAndAthleteId(i, athleteId);
                float outcome = outcomeObject.getOutcome();
                System.out.println("event" + i + " outcome is: " + outcome);
                outcomes.add(outcome);
            } catch (NullPointerException e) {
                outcomes.add((float) 0);
                System.out.println("This outcome is missing: " + athleteId + '.' + i);
            }
        }
        System.out.println(outcomes);

        float score = 0;
        for (Float outcome : outcomes) {
            score += outcome*outcome;
        }
        return score;
    }

    @GetMapping("all-scores")
    public Map<String, Float> getAllScores() {
        Map<String, Float> athleteScoreMap = new HashMap<>();
        List<Long> athleteIds = athleteRepository.findAthleteIds();
        for (Long athleteId : athleteIds) {
            Optional<Athlete> athleteOp = athleteRepository.findById(athleteId);
            Athlete athlete = athleteOp.orElseThrow();
            String athleteName = athlete.getName();
            Float athleteScore = getAthleteScore(athleteId);
            athleteScoreMap.put(athleteName, athleteScore);
        }
        return athleteScoreMap;
    }

    @DeleteMapping("outcomes")
    public List<Outcome> deleteOutcome(@RequestParam Long outcomeId) {
        outcomeRepository.deleteById(outcomeId);
        return outcomeRepository.findAll();
    }

}
