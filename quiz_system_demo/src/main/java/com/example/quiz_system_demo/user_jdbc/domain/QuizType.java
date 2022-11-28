package com.example.quiz_system_demo.user_jdbc.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class QuizType {
    private int id;
    private String typeName;
    private int timeLimit;
    private String description;
}
