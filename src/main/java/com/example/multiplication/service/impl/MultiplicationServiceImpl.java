package com.example.multiplication.service.impl;

import com.example.multiplication.domain.Multiplication;
import com.example.multiplication.domain.MultiplicationResultAttempt;
import com.example.multiplication.service.MultiplicationService;

/**
 * {@inheritDoc}
 */
public class MultiplicationServiceImpl implements MultiplicationService {
    @Override
    public Multiplication createRandomMultiplication() {
        return null;
    }

    @Override
    public boolean checkAttempt(MultiplicationResultAttempt resultAttempt) {
        return resultAttempt.getResultAttempt() ==
                resultAttempt.getMultiplication().getFactorA() * resultAttempt.getMultiplication().getFactorB();
    }
}
