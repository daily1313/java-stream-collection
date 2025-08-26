package com.example.abstraction.abstractclass;

public class Application {

    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();

        cat.makeSound();
        dog.makeSound();

        cat.eat();
        dog.eat();
    }
}
