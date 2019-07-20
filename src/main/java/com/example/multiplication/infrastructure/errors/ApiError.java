package com.example.multiplication.infrastructure.errors;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiError {
    private String message;
    private String location;
}
