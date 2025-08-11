package com.example.stream.q2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q2 {

    private static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    // 2.1 List에 저장된 단어들의 접두사가 각각 몇개씩 있는지 Map<String, Integer>으로 변환하여라.
    // ex) ("T", 1), ("a", 2) ...
    public Map<String, Integer> quiz1() {
        Map<String, Integer> results = WORDS.stream()
                .map(word -> word.substring(0, 1))
                .collect(Collectors.toMap(key -> key, value -> 1, Integer::sum));

        results.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });

        return results;
    }

    // 2.2 List에 저장된 단어들 중에서 단어의 길이가 2 이상인 경우에만, 모든 단어를 대문자로 변환하여 스페이스로 구분한 하나의 문자열로 합한 결과를 반환하여라.
    // ex) ["Hello", "a", "Island", "b"] -> “H I”
    public String quiz2() {
        String result = WORDS.stream()
                .filter(word -> word.length() >= 2)
                .map(word -> word.substring(0, 1).toUpperCase())
                .collect(Collectors.joining(" "));

        System.out.println(result);
        return result;
    }
}
