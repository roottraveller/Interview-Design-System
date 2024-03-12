package com.company.booking.services.impl.sourceEndPoint;

import com.company.booking.domain.UserBooking;
import com.company.booking.domain.request.BookingRequest;
import com.company.booking.domain.request.NotificationRequest;
import com.company.booking.domain.request.PaymentRequest;
import com.company.booking.domain.vehicle.seat.Seat;
import com.company.booking.domain.vehicle.seat.SeatStatus;
import com.company.booking.services.SourceEndPoint;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.booking.services.NotificationService;
import com.company.booking.services.PaymentService;

/**
 * Support booking for my own bus
 */
public class MyOwnBusSourceEndPoint implements SourceEndPoint {
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private PaymentService paymentService;

    @Override
    public boolean addBooking(BookingRequest request) {
        /*
          long busId = request.getBusId();
          fetch bus details and check if seat is free or not
          if free, try to book it else false notify
         */

        Seat seat = request.getSeat();
        // If seat is free try to book it
        if(seat.getSeatStatus() == SeatStatus.FREE) {
            synchronized (seat) {
                seat.setSeatStatus(SeatStatus.BOOKED);
                paymentService.pay(new MyOwnBusSourceEndPoint().paymentRequest(request));
                notificationService.notify(new MyOwnBusSourceEndPoint().notificationRequest(request));
                return true;
            }
        }

        return false;
    }

    @Override
    public UserBooking getBooking(long bookingId) {

        /*
            check if there is any booking for given bookingId
            and return details
         */
        return null;
    }

    @Override
    public boolean cancelBooking(long bookingId) {
        /*
          get booking details based on bookingId and try to cancel it
         */
        Seat seat = seatDetails(bookingId);
        synchronized (seat) {
            seat.setSeatStatus(SeatStatus.FREE);
//            paymentService.pay(new MyOwnBusSourceEndPoint().paymentRequest(bookingRequest));
//            notificationService.notify(new MyOwnBusSourceEndPoint().notificationRequest(bookingRequest));
            return true;
        }
    }

    /**
     * create payment request from booking request
     * @param bookingRequest
     * @return
     */
    private PaymentRequest paymentRequest(BookingRequest bookingRequest) {
        return null;
    }

    /**
     * create notification request form booking request
     * @param bookingRequest
     * @return
     */
    private NotificationRequest notificationRequest(BookingRequest bookingRequest) {
        return null;
    }

    /**
     * return seat details based on bookingId
     * @param bookingId
     * @return
     */
    private Seat seatDetails(long bookingId) {
        return new Seat();
    }
}
