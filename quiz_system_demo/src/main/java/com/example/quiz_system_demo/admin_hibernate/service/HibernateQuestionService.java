package com.example.quiz_system_demo.admin_hibernate.service;

import com.example.quiz_system_demo.admin_hibernate.dao.HibernateQuestionDAO;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HibernateQuestionService {

    private HibernateQuestionDAO questionDAO;

    @Autowired
    @Qualifier("hibernateQuestionDAO")
    public void setQuestionDAO(HibernateQuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @Transactional
    public HibernateQuestion getQuestionById(Integer questionId) {
        return questionDAO.getQuestionById(questionId);
    }
}
