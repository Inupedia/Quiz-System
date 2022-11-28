package com.example.quiz_system_demo.user_jdbc.service;

import com.example.quiz_system_demo.user_jdbc.dao.FeedbackDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
    private final FeedbackDAO feedbackDAO;

    @Autowired
    public FeedbackService(FeedbackDAO feedbackDAO) {
        this.feedbackDAO = feedbackDAO;
    }

    // insert feedback into database
    public void insertFeedback(String rating, String feedback, int quizTypeId) {
        feedbackDAO.insertFeedback(rating, feedback, quizTypeId);
    }

}
