package com.example.function.consumer;

import java.util.function.Consumer;

public class Application {

    public static void main(String[] args) {
        Consumer<Integer> c1 = t -> System.out.println("input = " + t);
        c1.accept(1);

        Logger logger1 = new Logger("TRACE");
        logger1.accept("trace log");

        Logger logger2 = new Logger("DEBUG");
        logger2.accept("debug log");

        Logger logger3 = new Logger("INFO");
        logger3.accept("info log");

        accept(logger1);
        accept(logger2);
        accept(logger3);
    }

    private static <T> void accept(T t) {
        if (t != null) {
            System.out.println(t);
        }
    }
}
