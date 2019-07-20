package com.example.multiplication.controller;

import com.example.multiplication.controller.response.ResultView;
import com.example.multiplication.controller.request.AttemptForm;
import com.example.multiplication.domain.MultiplicationResultAttempt;
import com.example.multiplication.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/results")
public class MultiplicationResultAttemptController {
    private final MultiplicationService multiplicationService;

    @Autowired
    public MultiplicationResultAttemptController(final MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    @PostMapping
    public ResponseEntity<ResultView> postResult(@RequestBody AttemptForm attemptForm) {
        MultiplicationResultAttempt attempt = attemptForm.toAttempt();
        boolean result = multiplicationService.checkAttempt(attempt);
        return ResponseEntity.ok(new ResultView(result));
    }
}
