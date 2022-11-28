package com.example.quiz_system_demo.user_jdbc.service;

import com.example.quiz_system_demo.user_jdbc.dao.SubmissionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class SubmissionService {
    private final SubmissionDAO submissionDAO;

    @Autowired
    public SubmissionService(SubmissionDAO submissionDAO) {
        this.submissionDAO = submissionDAO;
    }

    // insert submission, if the submission already exists, update it with higher score
    public void insertSubmission(int userId, int quizTypeId, int score, Timestamp startTime, Timestamp endTime) {
        submissionDAO.insertSubmission(userId, quizTypeId, score, startTime, endTime);
    }

    // get score by user id and quiz type id
    public int getScoreByUserIdAndQuizTypeId(int userId, int quizTypeId) {
        return submissionDAO.getScoreByUserIdAndQuizTypeId(userId, quizTypeId);
    }

    //delete submission by user id and quiz type id
    public void deleteSubmissionByUserIdAndQuizTypeId(int userId, int quizTypeId) {
        submissionDAO.deleteSubmissionByUserIdAndQuizTypeId(userId, quizTypeId);
    }

    // get submission id by user id and quiz type id
    public int getSubmissionIdByUserIdAndQuizTypeId(int userId, int quizTypeId) {
        return submissionDAO.getSubmissionIdByUserIdAndQuizTypeId(userId, quizTypeId);
    }
}
