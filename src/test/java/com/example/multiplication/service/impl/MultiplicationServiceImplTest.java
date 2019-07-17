package com.example.multiplication.service.impl;

import com.example.multiplication.domain.Multiplication;
import com.example.multiplication.domain.MultiplicationResultAttempt;
import com.example.multiplication.domain.User;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplicationServiceImplTest {

    MultiplicationServiceImpl multiplicationService = new MultiplicationServiceImpl();

    @Test
    public void checkCorrectAttemptTest() {
        // Given
        Multiplication multiplication= new Multiplication(50, 60);
        User user = new User("chinv");
        int resultAttempt = 50 * 60;
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, resultAttempt);

        // When
        boolean attemptResult = multiplicationService.checkAttempt(attempt);

        // Then
        assertThat(attemptResult).isTrue();
    }

    @Test
    public void checkWrongAttemptTest() {
        // given
        Multiplication multiplication= new Multiplication(50, 60);
        User user = new User("chinv");
        int resultAttempt = 50 * 60 + 1;
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, resultAttempt);

        // when
        boolean attemptResult = multiplicationService.checkAttempt(attempt);

        // then
        assertThat(attemptResult).isFalse();
    }
}