package com.example.travel.restcontroller;

import com.example.travel.model.Passenger;
import com.example.travel.model.Reservation;
import com.example.travel.model.Tour;
import com.example.travel.repository.PassengerRepository;
import com.example.travel.repository.ReservationRespository;
import com.example.travel.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class TourRestController {

    @Autowired
    TourRepository tourRepository;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    ReservationRespository reservationRespository;

    @PostMapping(value = "/api/create-tour", consumes = "application/json")
    public ResponseEntity<Tour> createTour(@RequestBody Tour tour) {
        tourRepository.save(tour);
        return new ResponseEntity<Tour>(tour, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/delete-tour/{id}")
    public ResponseEntity<Integer> deleteTour(@PathVariable("id") Integer id) {
        tourRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/api/get-tours")
    public ResponseEntity<List<Tour>> getTours() {
        return new ResponseEntity<>(tourRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/get-tour/{id}")
    public ResponseEntity<Tour> getTour(@PathVariable("id") Integer id) {
        Optional<Tour> tourOptional = tourRepository.findById(id);
        if (!tourOptional.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tourOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/api/get-passenger-count/{id}")
    public ResponseEntity<Tour> getPassenger(@PathVariable("id") Integer id) {
        Optional<Tour> tourOptional = tourRepository.findById(id);
        if (!tourOptional.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tourOptional.get(), HttpStatus.OK);
    }


    @PutMapping(value = "/api/save-tour", consumes = "application/json")
    public ResponseEntity<Tour> saveTour(@RequestBody Tour tour) {
        tourRepository.save(tour);
        return new ResponseEntity<>(tour, HttpStatus.ACCEPTED);
    }

    @PostMapping("api/book_tour/")
    public ResponseEntity<Passenger> passengers(@RequestParam Integer tourId, @RequestParam List<String> passengerInputList) {

        Set<Passenger> passengersSetList = new HashSet<>();
        for (String passengerName : passengerInputList) {
            Passenger passenger1 = new Passenger(passengerName);
            passengerRepository.save(passenger1);
            passengersSetList.add(passenger1);
        }

        Reservation reservation = new Reservation();
        reservation.setPassengers(passengersSetList);
        Optional<Tour> tourOptional = tourRepository.findById(tourId);

        if (!tourOptional.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Tour tour = tourOptional.get();
        reservation.setTour(tour);
        reservationRespository.save(reservation);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
