package com.example.quiz_system_demo.admin_hibernate.restDomain;

import com.example.quiz_system_demo.admin_hibernate.domain.dto.QuizResult;

import java.util.List;
import lombok.*;

@Getter
@Setter
@Builder
public class QuizResponse {

    private ResponseStatus status;
    private List<AllQuizResult> quizResults;
}
