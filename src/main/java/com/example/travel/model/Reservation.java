package com.example.travel.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    Integer reservationId;

    LocalDateTime startDateAndTime;

    LocalDateTime endDateAndTime;

    LocalDateTime reservedDateAndTime;

    @ManyToOne
    @JoinColumn(name = "tourId")
    private Tour tour;

    @OneToMany
    @JoinColumn(name = "reservationId")
    private Set<Passenger> passengers = new HashSet<>();

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    //no getter for tour because of infinite recursion

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    public LocalDateTime getStartDateAndTime() {
        return startDateAndTime;
    }

    public void setStartDateAndTime(LocalDateTime startDateAndTime) {
        this.startDateAndTime = startDateAndTime;
    }

    public LocalDateTime getEndDateAndTime() {
        return endDateAndTime;
    }

    public void setEndDateAndTime(LocalDateTime endDateAndTime) {
        this.endDateAndTime = endDateAndTime;
    }

    public LocalDateTime getReservedDateAndTime() {
        return reservedDateAndTime;
    }

    public void setReservedDateAndTime(LocalDateTime reservedDateAndTime) {
        this.reservedDateAndTime = reservedDateAndTime;
    }
}
