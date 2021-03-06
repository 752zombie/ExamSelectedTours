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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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


    @PostMapping(value = "/api/book-tour", consumes = "application/json")
    public ResponseEntity<Reservation> bookTour(@RequestBody Reservation reservation) {

        //save when the reservation was made
        reservation.setReservedDateAndTime(LocalDateTime.now());

        //calculate and save end date
        int duration = reservation.getTour().getDurationDays();
        LocalDateTime startDate = reservation.getStartDateAndTime();
        LocalDateTime endDate = startDate.plusDays(duration);
        reservation.setEndDateAndTime(endDate);

        //save price at reserved time
        reservation.setPriceAtReservedTime(reservation.getTour().getPrice());

        //save number of passengers
        reservation.setNumberOfPassengers(reservation.getPassengers().size());

        for (Passenger passenger : reservation.getPassengers()) {
            passengerRepository.save(passenger);
        }
        reservationRespository.save(reservation);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }
}
