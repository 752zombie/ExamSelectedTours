package com.example.travel.controller;

import com.example.travel.model.Passenger;
import com.example.travel.model.Reservation;
import com.example.travel.model.Tour;
import com.example.travel.repository.PassengerRepository;
import com.example.travel.repository.ReservationRespository;
import com.example.travel.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class TourController {

    @Autowired
    TourRepository tourRepository;
    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRespository reservationRespository;

    @GetMapping("/create-tour")
    public String createTourPage() {
        return "create-tour";
    }

    @GetMapping("/tour-admin-overview")
    public String tourAdminOverview() {
        return "tour-admin-overview";
    }

    @GetMapping("/tour-admin/{id}")
    public String getTourAdmin(@PathVariable("id") Integer id) {
        return "edit-tour";
    }

    @GetMapping("/get_tours")
    public String getTours() { return "reserve_tour"; }

    @PostMapping("/reserve_tour")
    public String reserveTour(@RequestParam int id, @RequestParam int numberOfTickets, Model model) {
        Optional<Tour> tour = tourRepository.findById(id);
        tour.ifPresent(value -> value.setTicketsReserved(value.getTicketsReserved() + numberOfTickets));
        tour.ifPresent(value -> tourRepository.save(value));
        model.addAttribute("numberOfTickets", numberOfTickets);
        model.addAttribute("tour_id", id);
        return "passengers";
    }

    @GetMapping("/reserve_tour/add_passengers")
    public String addPassengers() { return "passengers";}

    @GetMapping("/date")
    public String dateTest() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Reservation reservation = new Reservation();
        reservation.setReservedDateAndTime(localDateTime);
        reservationRespository.save(reservation);
        return "dummy2";
    }



}
