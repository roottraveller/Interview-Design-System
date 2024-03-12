package com.company.booking.domain.route;

import java.time.LocalDateTime;

/**
 * information of a location i.e substation
 */
public class Location {
    private String name;
    private String source;
    private double distanceFromSource;
    private LocalDateTime timeToReach;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getDistanceFromSource() {
        return distanceFromSource;
    }

    public void setDistanceFromSource(double distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }

    public LocalDateTime getTimeToReach() {
        return timeToReach;
    }

    public void setTimeToReach(LocalDateTime timeToReach) {
        this.timeToReach = timeToReach;
    }
}
