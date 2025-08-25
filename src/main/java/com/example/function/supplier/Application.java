package com.example.function.supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Application {

    public static void main(String[] args) {
        Supplier<List<String>> listSupplier = () -> Arrays.asList("a", "b", "c");

        BooleanSupplier booleanSupplier = () -> true;

        IntSupplier intSupplier = () -> {
            return (int) (Math.random() * 6) + 1;
        };

        DoubleSupplier doubleSupplier = () -> 1.0;

        LongSupplier longSupplier = () -> 1L;


        System.out.println(listSupplier.get());
        System.out.println(booleanSupplier.getAsBoolean());
        System.out.println(intSupplier.getAsInt());
        System.out.println(doubleSupplier.getAsDouble());
        System.out.println(longSupplier.getAsLong());
    }
}
