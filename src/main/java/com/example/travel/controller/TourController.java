package com.example.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TourController {

    @GetMapping("/create-tour")
    public String createTourPage() {
        return "create-tour";
    }

    @GetMapping("/tour-admin-overview")
    public String tourAdminOverview() {
        return "tour-admin-overview";
    }


}
