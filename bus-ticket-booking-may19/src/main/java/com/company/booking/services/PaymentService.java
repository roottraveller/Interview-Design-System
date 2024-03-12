package com.company.booking.services;

import com.company.booking.domain.request.PaymentRequest;

public interface PaymentService {

    boolean pay(PaymentRequest paymentRequest);

}
