package com.example.multiplication.controller.request;

import com.example.multiplication.controller.response.BadRequestException;
import com.example.multiplication.domain.Multiplication;
import com.example.multiplication.domain.MultiplicationResultAttempt;
import com.example.multiplication.domain.User;
import com.example.multiplication.infrastructure.errors.ApiError;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor @Builder
@Getter
public class AttemptForm {
    private final String user;
    private final int factorA;
    private final int factorB;
    private final int resultAttempt;

    public MultiplicationResultAttempt toAttempt() {
        validate();
        return new MultiplicationResultAttempt(
                new User(user),
                new Multiplication(factorA, factorB),
                resultAttempt);
    }

    private void validate() {
        List<ApiError> errors = new ArrayList<>();
        if (StringUtils.isEmpty(user)) {
            errors.add(ApiError.builder()
                    .message("user must present")
                    .location("user")
                    .build());
        }

        if (errors.size() > 0) {
            throw new BadRequestException(errors);
        }
    }
}
