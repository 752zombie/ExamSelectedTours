package com.example.travel.model;

import javax.persistence.*;

@Entity
public class Passenger {

    @Id
    @GeneratedValue
    Integer passengerId;
    String name;

    @ManyToOne
    @JoinColumn(name = "tourId")
    private Tour tour;

    @ManyToOne
    @JoinColumn(name = "resevationId")
    private Reservation reservation;

    public Passenger() {}

    public Passenger(String name) {
        this.name = name;
    }

    public Integer getPassenger_id() { return passengerId; }

    public void setPassenger_id(Integer passengerId) { this.passengerId = passengerId; }

    public String getPassenger() { return name; }

    public void setPassenger(String passenger) { this.name = passenger; }
}
