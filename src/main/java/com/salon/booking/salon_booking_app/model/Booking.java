package com.salon.booking.salon_booking_app.model;

public class Booking {
    private Long id;
    private Long userId;
    private Long salonId;
    private String timeSlot;

    public Booking(Long id, Long userId, Long salonId, String timeSlot) {
        this.id = id;
        this.userId = userId;
        this.salonId = salonId;
        this.timeSlot = timeSlot;
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Long getSalonId() { return salonId; }
    public String getTimeSlot() { return timeSlot; }
}
