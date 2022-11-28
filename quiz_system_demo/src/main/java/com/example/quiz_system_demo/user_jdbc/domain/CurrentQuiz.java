package com.example.quiz_system_demo.user_jdbc.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CurrentQuiz {
    private int index;
    private Question question;
    private List<Option> options;
}
