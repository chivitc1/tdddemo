package com.example.multiplication.controller;

import com.example.multiplication.controller.response.MultiplicationView;
import com.example.multiplication.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/multiplications")
public class MultiplicationController {
    private final MultiplicationService multiplicationService;

    @Autowired
    public MultiplicationController(final MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    @GetMapping("/random")
    public MultiplicationView getRandomMultiplication() {
        MultiplicationView multiplicationView = new MultiplicationView(multiplicationService.createRandomMultiplication());
        return multiplicationView;
    }
}
