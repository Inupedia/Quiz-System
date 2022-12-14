package com.example.quiz_system_demo.user_jdbc.service;

import com.example.quiz_system_demo.user_jdbc.dao.QuestionDAO;
import com.example.quiz_system_demo.user_jdbc.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionDAO questionDAO;

    @Autowired
    public QuestionService(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    // get 10 random questions
    public List<Question> getRandomQuestions(int quizTypeId, int numOfQuestions) {
        return questionDAO.getRandomQuestions(quizTypeId, numOfQuestions);
    }

}
