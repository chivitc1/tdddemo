package com.example.multiplication.controller.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * The returned view of AttemptResult
 */
@Getter @RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class ResultView {
    private final boolean correct;
}
