package com.company.booking.services.impl.sourceEndPoint;


import com.company.booking.domain.UserBooking;
import com.company.booking.domain.request.BookingRequest;
import com.company.booking.services.SourceEndPoint;

/**
 *  API's provided by agent1
 */
public class Agent1SourceEndPoint implements SourceEndPoint {

    @Override
    public boolean addBooking(BookingRequest request) {
        return false;
    }

    @Override
    public UserBooking getBooking(long bookingId) {
        return null;
    }

    @Override
    public boolean cancelBooking(long bookingId) {
        return false;
    }
}
