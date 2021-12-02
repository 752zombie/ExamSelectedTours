package com.example.travel.repository;

import com.example.travel.model.Passenger;
import com.example.travel.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRespository extends JpaRepository<Reservation, Integer> {
}
