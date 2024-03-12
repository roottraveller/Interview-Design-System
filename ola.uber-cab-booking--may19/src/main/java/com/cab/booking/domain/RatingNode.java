package com.cab.booking.domain;

import com.cab.booking.domain.user.User;

public class RatingNode {
    private User user;
    private double rating;

    public RatingNode(User user, double rating) {
        this.user = user;
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
