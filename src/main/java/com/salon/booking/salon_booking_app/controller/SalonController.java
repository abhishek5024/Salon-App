package com.salon.booking.salon_booking_app.controller;

import com.salon.booking.salon_booking_app.model.Salon;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/salons")
public class SalonController {
    private final List<Salon> salons = new ArrayList<>();

    @GetMapping
    public List<Salon> getAllSalons() {
        return salons;
    }

    @PostMapping
    public Salon createSalon(@RequestBody Salon salon) {
        salons.add(salon);
        return salon;
    }
}
