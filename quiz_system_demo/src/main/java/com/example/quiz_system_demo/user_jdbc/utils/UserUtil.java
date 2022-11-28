package com.example.quiz_system_demo.user_jdbc.utils;

import com.example.quiz_system_demo.user_jdbc.domain.CurrentQuiz;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class UserUtil {
    private int currentUserId;
    private int currentQuizTypeId;
    private List<CurrentQuiz> currentQuizList;
    private Timestamp startTime;
    private Timestamp endTime;

    public boolean isCorrect(int questionId, String userAnswer) {
        for (CurrentQuiz currentQuiz : currentQuizList) {
            if (currentQuiz.getQuestion().getId() == questionId) {
                return currentQuiz.getQuestion().getCorrectAnswer().equals(userAnswer);
            }
        }
        return false;
    }

}
