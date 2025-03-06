package com.salon.booking.salon_booking_app.model;

public class Salon {
    private Long id;
    private String name;
    private String location;

    public Salon(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
}
