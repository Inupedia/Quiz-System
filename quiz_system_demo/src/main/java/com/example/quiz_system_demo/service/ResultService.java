package com.example.quiz_system_demo.service;

import com.example.quiz_system_demo.dao.ResultDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {

    private final ResultDAO resultDAO;

    @Autowired
    public ResultService(ResultDAO resultDAO) {
        this.resultDAO = resultDAO;
    }

    // insert result
    public void insertResult(int submissionId, int questionId, String userChoice) {
        resultDAO.insertResult(submissionId, questionId, userChoice);
    }

    // delete result by submission id
    public void deleteResultBySubmissionId(int submissionId) {
        resultDAO.deleteResultBySubmissionId(submissionId);
    }

    // get result by question id
    public String getResultByQuestionId(int questionId) {
        return resultDAO.getResultByQuestionId(questionId);
    }

}
