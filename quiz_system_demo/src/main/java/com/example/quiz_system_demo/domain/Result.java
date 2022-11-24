package com.example.quiz_system_demo.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Result {
    private int resultId;
    private String userChoice;
    private int questionId;
    private int submissionId;
}
