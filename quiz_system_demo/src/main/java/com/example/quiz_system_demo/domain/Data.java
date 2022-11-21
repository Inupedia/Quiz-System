package com.example.quiz_system_demo.domain;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Data {
    private Question question;
    private ArrayList<Option> answers;
}
