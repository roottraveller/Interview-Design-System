package com.company.booking.web;

import com.company.booking.domain.UserBooking;
import com.company.booking.domain.request.BookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.company.booking.services.impl.booking.BusBookingService;


@RestController
@RequestMapping("/booking")
public class BusBookingController {
    @Autowired
    private BusBookingService busBookingService;


    @PostMapping
    public ResponseEntity postNewBooking(@RequestBody BookingRequest bookingRequest) {
        return new ResponseEntity<>(busBookingService.addNewBooking(bookingRequest), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity getBookingDetails(@RequestParam long bookingId) {
        // Return booking details if found else null
        return new ResponseEntity<>(busBookingService.getBookingDetails(bookingId), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity cancelBooking(@RequestParam long bookingId) {
        // Cancel existing booking else throw exception
        busBookingService.cancelBooking(bookingId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // other API's

}
