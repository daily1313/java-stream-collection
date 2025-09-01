package com.example.foreach.collection;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Collection {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d");

        // enhanced for-loop
        for(String str : list) {
            System.out.println(str);
        }

        // forEach
        Consumer<String> consumer = System.out::println;
        list.forEach(consumer);
    }
}
