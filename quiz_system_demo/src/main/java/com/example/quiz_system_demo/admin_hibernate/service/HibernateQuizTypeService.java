package com.example.quiz_system_demo.admin_hibernate.service;

import com.example.quiz_system_demo.admin_hibernate.dao.HibernateQuizTypeDAO;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateQuizType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HibernateQuizTypeService {

    private HibernateQuizTypeDAO quizTypeDAO;

    @Autowired
    @Qualifier("hibernateQuizTypeDAO")
    public void setQuizTypeDAO(HibernateQuizTypeDAO quizTypeDAO) {
        this.quizTypeDAO = quizTypeDAO;
    }

    @Transactional
    public List<HibernateQuizType> findAll() {
        return quizTypeDAO.findAll();
    }
}
