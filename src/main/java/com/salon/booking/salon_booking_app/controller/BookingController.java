package com.salon.booking.salon_booking_app.controller;

import com.salon.booking.salon_booking_app.model.Booking;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final List<Booking> bookings = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookings;
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        Booking newBooking = new Booking(counter.incrementAndGet(), booking.getUserId(), booking.getSalonId(), booking.getTimeSlot());
        bookings.add(newBooking);
        return newBooking;
    }
}
