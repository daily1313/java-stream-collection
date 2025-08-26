package com.example.abstraction.lnterface;

public class OrderPayment {

    private Payment payment;

    public OrderPayment(Payment payment) {
        this.payment = payment;
    }

    public void changePaymentMethod(Payment payment) {
        this.payment = payment;
    }

    public void pay() {
        payment.pay();
    }
}
