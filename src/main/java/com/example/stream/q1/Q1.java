package com.example.stream.q1;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q1 {

    // 1.1 각 취미를 선호하는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz1() throws IOException {
        List<String[]> csvLines = readCsvLines();

        return csvLines.stream()
                .flatMap(hobby -> Arrays.stream(hobby[1].replaceAll("\\s", "").split(":")))
                .collect(Collectors.toMap(key -> key, key -> 1, (oldValue, newValue) -> newValue += oldValue));
    }

    // 1.2 각 취미를 선호하는 정씨 성을 갖는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz2() throws IOException {
        List<String[]> csvLines = readCsvLines();

        return csvLines.stream()
                .filter(name -> name[0].startsWith("정"))
                .flatMap(hobby -> Arrays.stream(hobby[1].replaceAll("\\s","").split(":")))
                .collect(Collectors.toMap(key -> key, key -> 1, Integer::sum));
    }

    // 1.3 소개 내용에 '좋아'가 몇번 등장하는지 계산하여라.
    public int quiz3() throws IOException {
        List<String[]> csvLines = readCsvLines();

        return csvLines.stream()
                .mapToInt(info -> countKeyword(info[2], "좋아"))
                .sum();
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
