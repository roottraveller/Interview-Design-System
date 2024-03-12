package com.cab.booking.services;

import com.cab.booking.domain.DestinationNode;
import com.cab.booking.domain.RatingNode;
import com.cab.booking.domain.user.Customer;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BookingServiceTest {
    private BookingService bookingService;

    public BookingServiceTest() {
        bookingService = new BookingService();
    }

    @Test
    public void test() {
        Customer customer;
        DestinationNode destinationNode;
        long seatRequired, requestedRides;
        double avgCustomerRating;
        List<RatingNode> driverRatings;

        customer = null; destinationNode = null; seatRequired = 0; requestedRides = 0; avgCustomerRating = 0; driverRatings = null;
        customer = new Customer("c1");
        destinationNode = new DestinationNode(12, 75);
        seatRequired = 1;
        avgCustomerRating = bookingService.getCustomerAvgRating(customer);
        driverRatings = bookingService.fetchEligibleDrivers(customer, destinationNode, seatRequired);
        requestedRides = bookingService.getCustomerRequestedRidesCount(customer);
//        printHumanMessage(customer, avgCustomerRating, driverRatings, requestedRides);

        customer = null; destinationNode = null; seatRequired = 0; requestedRides = 0; avgCustomerRating = 0; driverRatings = null;
        customer = new Customer("c2");
        destinationNode = new DestinationNode(12.5, 75.5);
        seatRequired = 2;
        avgCustomerRating = bookingService.getCustomerAvgRating(customer);
        driverRatings = bookingService.fetchEligibleDrivers(customer, destinationNode, seatRequired);
        requestedRides = bookingService.getCustomerRequestedRidesCount(customer);
//        printHumanMessage(customer, avgCustomerRating, driverRatings, requestedRides);

        customer = null; destinationNode = null; seatRequired = 0; requestedRides = 0; avgCustomerRating = 0; driverRatings = null;
        customer = new Customer("c3");
        destinationNode = new DestinationNode(12, 77);
        seatRequired = 2;
        avgCustomerRating = bookingService.getCustomerAvgRating(customer);
        driverRatings = bookingService.fetchEligibleDrivers(customer, destinationNode, seatRequired);
        requestedRides = bookingService.getCustomerRequestedRidesCount(customer);
        printHumanMessage(customer, avgCustomerRating, driverRatings, requestedRides);
    }

    private void printHumanMessage(Customer customer, double avgCustomerRating, List<RatingNode> driverRatings, long requestedRides) {
        System.out.println("-------------------------------------------------------");
        System.out.println("Average rating of " + customer.getName() + ": " + avgCustomerRating);
        System.out.print("Drivers with rating: [");
        if (driverRatings != null) {
            requestedRides += 1;
            for (RatingNode ratingNode : driverRatings) {
                System.out.print("(" + ratingNode.getUser().getName() + "," + ratingNode.getRating() + "), ");
            }
        }
        System.out.println("]");
        System.out.println("Requested rides: " + requestedRides);
    }

}
