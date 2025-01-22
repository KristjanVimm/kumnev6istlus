package com.kristjan.kumnev6istlus.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long athleteId;
    private String name;
    private String country;
    private int age;

    public Athlete(String name, String country, int age) {
        this.name = name;
        this.country = country;
        this.age = age;
    }


    public Athlete(Long athleteId, String name, String country, int age) {
        this.athleteId = athleteId;
        this.name = name;
        this.country = country;
        this.age = age;
    }

    public Athlete() {
    }

    public Long getAthleteId() {
        return this.athleteId;
    }

    public String getName() {
        return this.name;
    }

    public String getCountry() {
        return this.country;
    }

    public int getAge() {
        return this.age;
    }

    public void setAthleteId(Long athleteId) {
        this.athleteId = athleteId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAge(int age) {
        this.age = age;
    }
}



