package com.example.stream.q2;

import com.example.stream.q1.A1;
import com.example.stream.q1.Q1;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2Test {

    private final A2 answer = new A2();
    private final Q2 quiz = new Q2();

    @Test
    void quiz1() throws IOException {
        assertThat(quiz.quiz1()).isEqualTo(answer.quiz1());
    }

    @Test
    void quiz2() throws IOException {
        assertThat(quiz.quiz2()).isEqualTo(answer.quiz2());
    }
}
