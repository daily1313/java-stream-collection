package com.example.abstraction.lnterface;

public class KakaoPay implements Payment {

    @Override
    public void pay() {
        System.out.println("kakao pay");
    }
}
