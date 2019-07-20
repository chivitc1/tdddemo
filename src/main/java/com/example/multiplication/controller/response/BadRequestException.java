package com.example.multiplication.controller.response;

import com.example.multiplication.infrastructure.errors.ApiError;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * For throwing error containing multiple errors related to bad request from user.
 */
@Getter @ToString
public class BadRequestException extends RuntimeException {
    private final List<ApiError> errors;
    public BadRequestException(List<ApiError> errors) {
        super();
        this.errors = errors;
    }
}
