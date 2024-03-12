package com.company.booking.domain.request;

import com.company.booking.domain.payment.PaymentMode;
import com.company.booking.domain.vehicle.seat.Seat;

import java.util.Date;

/**
 *  booking request come in this form
 */
public class BookingRequest {
    private String source;
    private String destination;
    private Date date;
    private long busId;
    private long userId;
    private Seat seat;
    private PaymentMode paymentMode;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getBusId() {
        return busId;
    }

    public void setBusId(long busId) {
        this.busId = busId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
