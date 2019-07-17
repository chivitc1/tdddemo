package com.example.multiplication.service;

import com.example.multiplication.domain.Multiplication;
import com.example.multiplication.domain.MultiplicationResultAttempt;

public interface MultiplicationService {
    /**
     * Create random {@link Multiplication} object.
     * @return a multiplication of randomly generated numbers
     */
    Multiplication createRandomMultiplication();

    /**
     * @param resultAttempt
     * @return true if the attempt matches the result of the multiplication, false otherwise
     */
    boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);
}
