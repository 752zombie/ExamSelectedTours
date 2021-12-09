package com.example.travel.model;

import javax.persistence.*;

@Entity
public class Passenger {

    @Id
    @GeneratedValue
    Integer passengerId;
    String name;

    @ManyToOne
    @JoinColumn(name = "reservationId")
    private Reservation reservation;

    public Passenger() {}

    public Passenger(String name) {
        this.name = name;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
