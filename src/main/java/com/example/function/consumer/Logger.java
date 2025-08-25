package com.example.function.consumer;

import java.util.function.Consumer;

public class Logger implements Consumer<String> {

    private final String level;

    public Logger(String level) {
        this.level = level.toUpperCase();
    }

    @Override
    public void accept(String value) {
        if(value != null) {
            System.out.printf("[%s] %s\n", level, value);
        }
    }

    @Override
    public String toString() {
        return "Logger{" +
                "level='" + level + '\'' +
                '}';
    }
}
