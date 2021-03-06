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

    Integer priceAtReservedTime;

    Integer numberOfPassengers;

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

    public Tour getTour() {
        return tour;
    }

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

    public Integer getPriceAtReservedTime() {
        return priceAtReservedTime;
    }

    public void setPriceAtReservedTime(Integer priceAtReservedTime) {
        this.priceAtReservedTime = priceAtReservedTime;
    }

    public Integer getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(Integer numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
