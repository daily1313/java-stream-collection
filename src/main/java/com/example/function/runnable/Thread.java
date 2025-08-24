package com.example.function.runnable;

public class Thread implements Runnable {

    private Runnable target;

    public Thread(Runnable target) {
        this.target = target;
    }

    @Override
    public void run() {
        if(target != null) {
            target.run();
        }
    }

    public void start() {
        new java.lang.Thread(this).start();
    }
}
