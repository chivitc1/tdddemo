package com.example.multiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Contains a reference
 * to the Multiplication and a reference to the User,
 * together with the value submitted (the attempt to solve
 * the operation) and the actual result.
 */
@Getter @EqualsAndHashCode @ToString
@RequiredArgsConstructor
public class MultiplicationResultAttempt {
    private final User user;
    private final Multiplication multiplication;
    private final int resultAttempt;

    MultiplicationResultAttempt() {
        user = null;
        multiplication = null;
        resultAttempt = -1;
    }
}
