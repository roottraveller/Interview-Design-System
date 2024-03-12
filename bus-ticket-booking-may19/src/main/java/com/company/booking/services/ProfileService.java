package com.company.booking.services;

import com.company.booking.domain.user.User;
import com.company.booking.domain.UserBooking;

import java.util.List;

public interface ProfileService {

    List<UserBooking> getUserBookingHistory(long usrId);

    User getUserProfile(long userId);
}
