package com.example.quiz_system_demo.user_jdbc.domain;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Submission {
    private int submissionId;
    private int score;
    private Date startTime;
    private Date endTime;
    private int userId;
    private int quizTypeId;
}
