package com.example.travel.repository;

import com.example.travel.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository  extends JpaRepository<Passenger, Integer> {
}
