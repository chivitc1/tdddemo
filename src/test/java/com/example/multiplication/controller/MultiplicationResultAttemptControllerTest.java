package com.example.multiplication.controller;

import com.example.multiplication.controller.request.AttemptForm;
import com.example.multiplication.controller.response.ResultView;
import com.example.multiplication.domain.MultiplicationResultAttempt;
import com.example.multiplication.service.MultiplicationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(MultiplicationResultAttemptController.class)
public class MultiplicationResultAttemptControllerTest {

    @MockBean
    private MultiplicationService multiplicationService;

    @Autowired
    MockMvc mockMvc;

    private JacksonTester<AttemptForm> jsonResult;
    private JacksonTester<ResultView> jsonResponse;

    @Before
    public void setUp() throws Exception {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void postResultReturnCorrect() throws Exception {
        genericParameterizedTest(false);
    }

    @Test
    public void postResultReturnInCorrect() throws Exception {
        genericParameterizedTest(true);
    }

    void genericParameterizedTest(final boolean correct) throws Exception {
        // given
        given(multiplicationService.checkAttempt(any(MultiplicationResultAttempt.class)))
                .willReturn(correct);
        String user = "chinv";
        int factorA = 50, factorB = 70;
        int result = correct? factorA * factorB : factorA * factorB + 1;

        AttemptForm attempt = AttemptForm.builder()
                .user(user)
                .factorA(factorA)
                .factorB(factorB)
                .resultAttempt(result)
                .build();

        // when
        MockHttpServletResponse response = mockMvc.perform(
                post("/results")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonResult.write(attempt).getJson())
        ).andReturn().getResponse();

        // verify
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonResponse.write(new ResultView(correct)).getJson()
        );
    }
}