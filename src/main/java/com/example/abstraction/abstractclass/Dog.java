package com.example.abstraction.abstractclass;

public class Dog extends Animal {

    @Override
    void makeSound() {
        System.out.println("woof");
    }

    @Override
    void eat() {
        System.out.println("eat dog chew");
    }
}
