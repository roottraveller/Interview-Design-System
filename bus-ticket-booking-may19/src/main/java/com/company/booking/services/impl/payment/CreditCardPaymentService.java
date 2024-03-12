package com.company.booking.services.impl.payment;

import com.company.booking.domain.request.PaymentRequest;
import com.company.booking.services.PaymentService;

public class CreditCardPaymentService implements PaymentService {

    @Override
    public boolean pay(PaymentRequest paymentRequest) {
        return false;
    }
}
