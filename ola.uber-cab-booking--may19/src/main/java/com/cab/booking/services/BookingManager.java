package com.cab.booking.services;

import com.cab.booking.constants.Constants;
import com.cab.booking.domain.rating.CustomerRating;
import com.cab.booking.domain.rating.DriverRating;
import com.cab.booking.domain.DestinationNode;
import com.cab.booking.domain.RatingNode;
import com.cab.booking.domain.RideInfo;
import com.cab.booking.domain.user.Customer;
import com.cab.booking.domain.user.Driver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingManager {
    private CustomerRating customerRating;
    private DriverRating driverRating;
    private Map<Driver, Customer> cancellationMap;
    private Map<Driver, RideInfo> ongoingRidesMap;

    public BookingManager() {
        customerRating = new CustomerRating();
        driverRating = new DriverRating();
        cancellationMap = new HashMap<>();
        ongoingRidesMap = new HashMap<>();
        init();
    }


    void init() {
        initRating();
        initCancellation();
        initOngoingRides();
    }

    public long getCustomerRequestedRidesCount(Customer customer) {
        return customerRating.getCustomerRequestedRidesCount(customer);
    }

    public double getCustomerAvgRating(Customer customer) {
        return driverRating.getCustomerAvgRating(customer);
    }

    public double getDriverAvgRating(Driver driver) {
        return customerRating.getDriverAvgRating(driver);
    }

    public List<RatingNode> getEligibleDrivers(Customer customer, DestinationNode destinationNode, long seatRequired) {
        List<RatingNode> ratingNodeList = new ArrayList<>();
        double avgCustomerRating = getCustomerAvgRating(customer);
        for (Map.Entry<Driver, RideInfo> entry : ongoingRidesMap.entrySet()) {
            Driver driver = entry.getKey();
            if (seatRequired + entry.getValue().getRiderCount() <= Constants.SEAT_THRESHOLD) {
                for (DestinationNode destinationNodeTemp : entry.getValue().getDestinationNodeList()) {
                    if (isInRange(destinationNodeTemp, destinationNode)) {
                        double avgDriverRating = getDriverAvgRating(driver);
                        if (isRatingCriteriaPass(driver, customer, avgDriverRating, avgCustomerRating)) {
                            ratingNodeList.add(new RatingNode(driver, avgDriverRating));
//                            if(ratingNodeList.size() == 0) {
//                                ratingNodeList.add(new RatingNode(driver, avgDriverRating));
//                            } else{
//                                for (RatingNode ratingNodeTemp : ratingNodeList) {
//                                    if (!ratingNodeTemp.getUser().getName().equalsIgnoreCase(driver.getName())) {
//                                        ratingNodeList.add(new RatingNode(driver, avgDriverRating));
//                                    }
//                                }
//                            }
                        }
                    }
                }
            }
        }
        return ratingNodeList;
    }

    private boolean isRatingCriteriaPass(Driver driver, Customer customer, double avgDriverRating, double avgCustomerRating) {
        if ((customerRating.getDriverRating(customer, driver) <= 1)
                || (driverRating.getCustomerRating(driver, customer) <= 1)
                || (cancellationMap.get(driver) != null && cancellationMap.get(driver).getName().equalsIgnoreCase(customer.getName()))) {
            return false;
        }
        if ((avgDriverRating < avgCustomerRating)) {
            return customerRating.isCustomerRideWithDriver(customer, driver);
        }
        return true;
    }

    private boolean isInRange(DestinationNode destinationNode1, DestinationNode destinationNode2) {
        return Math.sqrt(Math.pow((destinationNode1.getLatitude() - destinationNode2.getLatitude()), 2) +
                Math.pow(destinationNode1.getLongitude() - destinationNode2.getLongitude(), 2)) <= Constants.DISTANCE_THRESHOLD;
    }

    /*****************************/

    private void initOngoingRides() {
        String fileName = "/home/rishi/Desktop/Flipkartddemo/src/main/resources/ongoing-rides.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                Driver driver = new Driver(tokens[0]);
                long riderCount = Long.parseLong(tokens[1]);
                List<DestinationNode> destinationNodeList = new ArrayList<>();
                for (int i = 2; i <= 2 * riderCount; i = i + 2) {
                    destinationNodeList.add(new DestinationNode(Double.parseDouble(tokens[i]), Double.parseDouble(tokens[i + 1])));
                }
                ongoingRidesMap.putIfAbsent(driver, new RideInfo(riderCount, destinationNodeList));
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    private void initCancellation() {
        String fileName = "/home/rishi/Desktop/Flipkartddemo/src/main/resources/cancellations.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                Driver driver = new Driver(tokens[0]);
                Customer customer = new Customer(tokens[1]);
                cancellationMap.putIfAbsent(driver, customer);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    private void initRating() {
        String fileName = "/home/rishi/Desktop/Flipkartddemo/src/main/resources/ratings.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                Customer customer = new Customer(tokens[0]);
                int ratingsByCustomerToDriver = Integer.parseInt(tokens[1]);
                Driver driver = new Driver(tokens[2]);
                int ratingsByDriverToCustomer = Integer.parseInt(tokens[3]);
                customerRating.addDriverRating(customer, driver, ratingsByCustomerToDriver);
                driverRating.addCustomerRating(driver, customer, ratingsByDriverToCustomer);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
