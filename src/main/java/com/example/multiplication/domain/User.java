package com.example.multiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter @EqualsAndHashCode @ToString @RequiredArgsConstructor
public final class User {
    private final String alias;
    protected User() {
        alias = null;
    }
}
