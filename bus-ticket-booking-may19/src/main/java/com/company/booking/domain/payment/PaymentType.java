package com.company.booking.domain.payment;

/**
 * information of a payment type available
 */
public class PaymentType {
    private long paymentTypeNo;
    private long accountNo;
    private PaymentMode paymentMode;

    public long getPaymentTypeNo() {
        return paymentTypeNo;
    }

    public void setPaymentTypeNo(long paymentTypeNo) {
        this.paymentTypeNo = paymentTypeNo;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
