package com.cab.booking.domain.rating;

import com.cab.booking.domain.RatingNode;
import com.cab.booking.domain.user.Customer;
import com.cab.booking.domain.user.Driver;
import com.cab.booking.exceptions.DriverNotRatedCustomerException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverRating {
    private Map<Driver, List<RatingNode>> driverToCustomerRatingMap;


    public DriverRating() {
        driverToCustomerRatingMap = new HashMap<>();
    }


    public boolean addCustomerRating(Driver driver, Customer customer, int rating) {
        List<RatingNode> ratingNodeList = driverToCustomerRatingMap.get(driver);
        if (ratingNodeList == null) {
            List<RatingNode> ratingNodes = new ArrayList<>();
            ratingNodes.add(new RatingNode(customer, rating));
            driverToCustomerRatingMap.putIfAbsent(driver, ratingNodes);
            return true;
        } else {
            ratingNodeList.add(new RatingNode(customer, rating));
            driverToCustomerRatingMap.putIfAbsent(driver, ratingNodeList);
            return true;
        }
    }

    public double getCustomerRating(Driver driver, Customer customer) {
        List<RatingNode> ratingNodeList = driverToCustomerRatingMap.get(driver);
        if (ratingNodeList == null) {
            throw new DriverNotRatedCustomerException("Driver not rated customer");
        } else {
            RatingNode ratingNode = ratingNodeList.stream()
                    .filter(it -> it.getUser().getName().equalsIgnoreCase(customer.getName()))
                    .findAny()
                    .orElse(null);
            return ratingNode != null ? ratingNode.getRating() : -1;
        }
    }

    public double getCustomerAvgRating(Customer customer) {
        double rating = 0.0;
        long posCount = 0;
        for (Map.Entry<Driver, List<RatingNode>> entry : driverToCustomerRatingMap.entrySet()) {
            for (RatingNode ratingNode : entry.getValue()) {
                if (ratingNode.getUser().getName().equalsIgnoreCase(customer.getName())) {
                    rating += ratingNode.getRating();
                    ++posCount;
                }
            }
        }
        return rating / posCount;
    }
}
