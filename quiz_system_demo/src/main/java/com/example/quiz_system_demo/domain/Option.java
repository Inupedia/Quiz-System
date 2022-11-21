package com.example.quiz_system_demo.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Option {
    private int id;
    private String optionDescription;
    private String questionId;
}
