package com.example.abstraction.abstractclass;

public class Cat extends Animal {

    @Override
    void makeSound() {
        System.out.println("meow");
    }

    @Override
    void eat() {
        System.out.println("eat chur");
    }
}
