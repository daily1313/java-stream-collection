package com.example.function.function;

import java.util.function.Function;

public class Application {

    public static void main(String[] args) {
        Function<Integer, Integer> doubleValue = x -> x * 2;
        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, Integer> addValue = x -> x + 2;

        System.out.println(doubleValue.apply(1));
        System.out.println(square.apply(1));
        System.out.println(addValue.apply(1));
    }
}
