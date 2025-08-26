package com.example.abstraction.lnterface;

public class Application {

    public static void main(String[] args) {
        OrderPayment payment = new OrderPayment(new BankTransfer());
        payment.pay();

        payment.changePaymentMethod(new CreditCard());
        payment.pay();

        payment.changePaymentMethod(new KakaoPay());
        payment.pay();
    }
}
