package com.cab.booking.domain.rating;

import com.cab.booking.domain.RatingNode;
import com.cab.booking.domain.user.Customer;
import com.cab.booking.domain.user.Driver;
import com.cab.booking.exceptions.CustomerNotRatedDriverException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRating {
    private Map<Customer, List<RatingNode>> customerToDriverRatingMap;


    public CustomerRating() {
        customerToDriverRatingMap = new HashMap<>();
    }

    public long getCustomerRequestedRidesCount(Customer customer) {
        return customerToDriverRatingMap.get(customer) != null ? customerToDriverRatingMap.get(customer).size() : -1;
    }

    public boolean isCustomerRideWithDriver(Customer customer, Driver driver) {
        return customerToDriverRatingMap.get(customer).stream()
                .filter(it -> it.getUser().getName().equalsIgnoreCase(driver.getName()))
                .findAny()
                .orElse(null) != null;
    }

    public boolean addDriverRating(Customer customer, Driver driver, int rating) {
        List<RatingNode> ratingNodeList = customerToDriverRatingMap.get(customer);
        if (ratingNodeList == null) {
            List<RatingNode> ratingNodes = new ArrayList<>();
            ratingNodes.add(new RatingNode(driver, rating));
            customerToDriverRatingMap.putIfAbsent(customer, ratingNodes);
            return true;
        } else {
            ratingNodeList.add(new RatingNode(driver, rating));
            customerToDriverRatingMap.putIfAbsent(customer, ratingNodeList);
            return true;
        }
    }

    public double getDriverRating(Customer customer, Driver driver) {
        List<RatingNode> ratingNodeList = customerToDriverRatingMap.get(customer);
        if (ratingNodeList == null) {
            throw new CustomerNotRatedDriverException("Customer not rated driver");
        } else {
            RatingNode ratingNode = ratingNodeList.stream()
                    .filter(it -> it.getUser().getName().equalsIgnoreCase(driver.getName()))
                    .findAny()
                    .orElse(null);
            return ratingNode != null ? ratingNode.getRating() : -1;
        }
    }

    public double getDriverAvgRating(Driver driver) {
        double rating = 0.0;
        long posCount = 0;
        for (Map.Entry<Customer, List<RatingNode>> entry : customerToDriverRatingMap.entrySet()) {
            for (RatingNode ratingNode : entry.getValue()) {
                if (ratingNode.getUser().getName().equalsIgnoreCase(driver.getName())) {
                    rating += ratingNode.getRating();
                    ++posCount;
                }
            }
        }
        return posCount != 0 ? rating / posCount : -1;
    }
}
