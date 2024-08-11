package com.vi.symphony.models;

import java.sql.Timestamp;

public class Booking {
    public int id;
    public int userId;
    public int eventId;
    public Timestamp bookingDate;
    public int amount;
    public String paymentMethod;
    public int ticketCount;

    public Booking(int id, int userId, int eventId, Timestamp bookingDate, int amount, String paymentMethod, int ticketCount) {
        this.id = id;
        this.userId = userId;
        this.eventId = eventId;
        this.bookingDate = bookingDate;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.ticketCount = ticketCount;
    }
};
