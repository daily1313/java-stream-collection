package com.example.foreach.collection;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Collection {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C", "D");

        // enhanced for-loop
        for(String str : list) {
            System.out.println(str);
        }

        // forEach
        Consumer<String> consumer = System.out::println;
        list.forEach(consumer);

        List<String> lists = new ReverseList();
        lists.addAll(list);

        lists.forEach(System.out::print);
        System.out.print(" ");
        lists.stream().forEach(System.out::print);
    }
}
