package com.example.function.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        Predicate<Integer> isEven = i -> i % 2 == 0;
        Predicate<Integer> isOdd = i -> i % 2 == 1;
        Predicate<String> isLargerThan5 = s -> s.length() >= 5;

        List<String> result = names.stream()
                .filter(isLargerThan5)
                .collect(Collectors.toList());

        System.out.println(isEven.test(0));
        System.out.println(isOdd.test(1));
        System.out.println(result);
    }
}
