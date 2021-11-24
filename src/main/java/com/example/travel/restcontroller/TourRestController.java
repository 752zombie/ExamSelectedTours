package com.example.travel.restcontroller;

import com.example.travel.model.Tour;
import com.example.travel.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TourRestController {
    @Autowired
    TourRepository tourRepository;

    @PostMapping(value = "/api/create-tour", consumes = "application/json")
    public ResponseEntity<Tour> createTour(@RequestBody Tour tour) {
        tourRepository.save(tour);
        return new ResponseEntity<Tour>(tour, HttpStatus.CREATED);
    }
}
