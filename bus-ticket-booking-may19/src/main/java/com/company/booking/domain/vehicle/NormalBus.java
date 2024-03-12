package com.company.booking.domain.vehicle;

import com.company.booking.domain.route.Route;

import java.util.List;

/**
 * a normal bus
 */
public class NormalBus extends Bus {
    private Route route;
    private double fareFactor;
    private List<String> runningDays;

    public NormalBus() {
        this.fareFactor = 10;
        this.runningDays = null;
        this.route = null;
    }

    public NormalBus(Route route, double fareFactor, List<String> runningDays) {
        this.route = route;
        this.fareFactor = fareFactor;
        this.runningDays = runningDays;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public double getFareFactor() {
        return fareFactor;
    }

    public void setFareFactor(double fareFactor) {
        this.fareFactor = fareFactor;
    }

    public List<String> getRunningDays() {
        return runningDays;
    }

    public void setRunningDays(List<String> runningDays) {
        this.runningDays = runningDays;
    }
}
