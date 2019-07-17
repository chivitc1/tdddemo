package com.example.multiplication.service.impl;

import com.example.multiplication.domain.Multiplication;
import com.example.multiplication.domain.MultiplicationResultAttempt;
import com.example.multiplication.domain.User;
import com.example.multiplication.service.RandomGeneratorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class MultiplicationServiceImplTest {

    @Mock
    RandomGeneratorService randomGeneratorService;

    MultiplicationServiceImpl multiplicationService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        multiplicationService = new MultiplicationServiceImpl
                (randomGeneratorService);
    }

    @Test
    public void createRandomMultiplicationTest() {
        // given
        given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);

        // when
        Multiplication multiplication = multiplicationService.createRandomMultiplication();

        // then
        assertThat(multiplication.getFactorA()).isEqualTo(50);
        assertThat(multiplication.getFactorB()).isEqualTo(30);
    }

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