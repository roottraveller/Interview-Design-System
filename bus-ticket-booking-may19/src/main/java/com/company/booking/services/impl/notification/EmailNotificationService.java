package com.company.booking.services.impl.notification;

import com.company.booking.domain.request.NotificationRequest;
import com.company.booking.services.NotificationService;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationService implements NotificationService {

    @Override
    public void notify(NotificationRequest notificationRequest) {

    }
}
