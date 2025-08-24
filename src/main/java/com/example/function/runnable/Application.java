package com.example.function.runnable;

public class Application {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Start Thread-1");
            }
        });

        Thread thread2 = new Thread(new Task());

        Thread thread3 = new Thread(() -> {
            System.out.println("Start Thread-3");
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
