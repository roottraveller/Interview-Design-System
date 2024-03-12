package com.company.booking.domain.route;

import java.util.List;

/**
 * a typical route of a vehicle
 */
public class Route {
    private long routeId;
    private String source;
    private String destination;
    private List<Location> subStation;

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Location> getSubStation() {
        return subStation;
    }

    public void setSubStation(List<Location> subStation) {
        this.subStation = subStation;
    }
}
