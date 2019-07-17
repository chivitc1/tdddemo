package com.example.multiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter @ToString @EqualsAndHashCode
@RequiredArgsConstructor
public class Multiplication {
    private final int factorA;
    private final int factorB;

    Multiplication() {
        this(0, 0);
    }
}
