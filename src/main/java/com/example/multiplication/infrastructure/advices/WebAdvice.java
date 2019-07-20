package com.example.multiplication.infrastructure.advices;

import com.example.multiplication.controller.response.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class WebAdvice {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity badRequest(BadRequestException e)
    {
        log.error("HELLLO");
        return ResponseEntity.badRequest().body(e.getErrors());
    }
}
