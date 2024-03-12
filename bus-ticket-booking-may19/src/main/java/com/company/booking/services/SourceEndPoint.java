package com.company.booking.services;


import com.company.booking.domain.UserBooking;
import com.company.booking.domain.request.BookingRequest;

public interface SourceEndPoint {

    boolean addBooking(BookingRequest request);

    UserBooking getBooking(long bookingId);

    boolean cancelBooking(long bookingId);
}
