package com.company.booking.services.impl.booking;

import com.company.booking.domain.UserBooking;
import com.company.booking.domain.busProvider.BusProvider;
import com.company.booking.domain.request.BookingRequest;
import com.company.booking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.booking.services.SourceEndPoint;

/**
 * com.company.booking.services for bus booking
 */
public class BusBookingService implements BookingService {
    @Autowired
    private SourceEndPoint sourceEndPoint;
    @Autowired
    private BusProvider busProvider;


    /**
     * Add new bus booking
     * @param bookingRequest
     * @return
     */
    public boolean addNewBooking(BookingRequest bookingRequest) {
        boolean status = validateBookingRequest(bookingRequest);
        if (!status) return false;

        // Get the busProvider sourceEndPoint based on busId
        sourceEndPoint = busProvider.getBusProvider(bookingRequest.getBusId());
        return sourceEndPoint.addBooking(bookingRequest);
    }

    /**
     * Get booking details for booking id
     * @param bookingId
     * @return
     */
    public UserBooking getBookingDetails(long bookingId) {
        // Get the busProvider sourceEndPoint based on busId
        sourceEndPoint = busProvider.getBusProvider(bookingId);
        return sourceEndPoint.getBooking(bookingId);
    }

    /**
     * Cancel booking for booking id
     * @param bookingId
     * @return
     */
    public boolean cancelBooking(long bookingId) {
        // Get the busProvider sourceEndPoint based on busId
        sourceEndPoint = busProvider.getBusProvider(bookingId);
        return sourceEndPoint.cancelBooking(bookingId);
    }

    /**
     * validate input booking request
     *
     * @param bookingRequest
     * @return
     */
    private boolean validateBookingRequest(BookingRequest bookingRequest) {
        return false;
    }
}
