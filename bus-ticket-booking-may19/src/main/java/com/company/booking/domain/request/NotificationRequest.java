package com.company.booking.domain.request;

import com.company.booking.domain.user.User;
import com.company.booking.domain.UserBooking;

/**
 * use to send a notification to user for a booking
 */
public class NotificationRequest {
    private User user;
    private UserBooking userBooking;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserBooking getUserBooking() {
        return userBooking;
    }

    public void setUserBooking(UserBooking userBooking) {
        this.userBooking = userBooking;
    }
}
