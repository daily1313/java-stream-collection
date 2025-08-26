package com.example.abstraction.lnterface;

public class BankTransfer implements Payment {

    @Override
    public void pay() {
        System.out.println("bank transfer");
    }
}
