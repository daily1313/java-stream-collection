package com.example.function.runnable;

public class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("start Thread-2");
    }
}
