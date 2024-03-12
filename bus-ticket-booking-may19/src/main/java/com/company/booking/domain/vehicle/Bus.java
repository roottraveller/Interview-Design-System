package com.company.booking.domain.vehicle;

import com.company.booking.domain.vehicle.seat.Seat;

import java.util.List;

/**
 * Vehicle of type bus
 */
public abstract class Bus implements Vehicle {
    protected long registrationId;
    protected String owner;
    protected List<Seat> seatList;

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(long registrationId) {
        this.registrationId = registrationId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
