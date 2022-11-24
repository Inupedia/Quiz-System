package com.example.quiz_system_demo.service;

import com.example.quiz_system_demo.dao.QuizTypeDAO;
import com.example.quiz_system_demo.domain.QuizType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizTypeService {

    private final QuizTypeDAO quizTypeDAO;

    @Autowired
    public QuizTypeService(QuizTypeDAO quizTypeDAO) {
        this.quizTypeDAO = quizTypeDAO;
    }

    // get all quiz types
    public List<QuizType> getAllQuizTypes() {
        return quizTypeDAO.getAllQuizTypes();
    }

}
