package com.example.abstraction.abstractclass;

public abstract class Animal {

    void eat() {
        System.out.println("eat");
    }

    void work() {
        System.out.println("work");
    }

    void sleep() {
        System.out.println("sleep");
    }

    final void awake() {
        System.out.println("awake");
    }

    abstract void makeSound();
}
