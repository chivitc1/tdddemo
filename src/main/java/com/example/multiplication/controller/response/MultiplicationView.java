package com.example.multiplication.controller.response;

import com.example.multiplication.domain.Multiplication;
import lombok.Getter;

/**
 * The returned view of Multiplication in api
 */
@Getter
public class MultiplicationView {
    private int factorA;
    private int factorB;
    public MultiplicationView(Multiplication multiplication) {
        this.factorA = multiplication.getFactorA();
        this.factorB = multiplication.getFactorB();
    }
}
