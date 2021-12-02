package com.example.travel.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tour {

    @Id
    @GeneratedValue
    Integer tourId;
    String tourName;

    @Lob
    String description;
    Integer price;
    Integer ticketsReserved = 0;

    @OneToMany
    @JoinColumn(name = "tourId")
    private Set<Passenger> passengers = new HashSet<>();

    public Tour() {}

    public Tour(Integer tourId, String tourName, String description, Integer price, Integer ticketsReserved) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.description = description;
        this.price = price;
        this.ticketsReserved = ticketsReserved;
    }

    public Integer getId() {
        return tourId;
    }

    public void setId(Integer id) {
        this.tourId = id;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTicketsReserved() { return ticketsReserved; }

    public void setTicketsReserved(Integer ticketsReserved) { this.ticketsReserved = ticketsReserved; }

    public Integer getTour_id() {
        return tourId;
    }

    public void setTour_id(Integer tour_id) {
        this.tourId = tour_id;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }
}
