package com.example.stream.q1;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q1 {

    // 1.1 각 취미를 선호하는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz1() throws IOException {
        List<String[]> csvLines = readCsvLines();

        Map<String, Integer> results = new HashMap<>();

        csvLines.stream()
                .flatMap(line -> Arrays.stream(line[1].replaceAll("\\s", "").split(":")))
                .forEach(hobby -> results.merge(hobby, 1, Integer::sum));

        results.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        });

        return results;
    }

    // 1.2 각 취미를 선호하는 정씨 성을 갖는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz2() throws IOException {
        List<String[]> csvLines = readCsvLines();

//        Map<String, Integer> results = csvLines.stream()
//                .filter(name -> name[0].startsWith("정"))
//                .flatMap(line -> Arrays.stream(line[1].replaceAll("\\s", "").split(":")))
//                .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));

        Map<String, Integer> results = new HashMap<>();
        csvLines.stream()
                        .filter(name -> name[0].startsWith("정"))
                        .flatMap(line -> Arrays.stream(line[1].replaceAll("\\s", "").split(":")))
                        .forEach(hobby -> results.merge(hobby, 1, Integer::sum));

        results.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        });

        return results;
    }

    // 1.3 소개 내용에 '좋아'가 몇번 등장하는지 계산하여라.
    public int quiz3() throws IOException {
        List<String[]> csvLines = readCsvLines();

        int count = csvLines.stream()
                .mapToInt(line -> countKeyword(line[2], "좋아"))
                .sum();

        return count;
    }

    private int countKeyword(String source, String target) {
        int index = source.indexOf(target);
        if(index == -1) {
            return 0;
        } else {
            return 1 + countKeyword(source.substring(index + 1), target);
        }
    }

    private List<String[]> readCsvLines() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();
        return csvReader.readAll();
    }
}
