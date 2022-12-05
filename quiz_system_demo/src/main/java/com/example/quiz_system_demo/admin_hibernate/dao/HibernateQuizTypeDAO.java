package com.example.quiz_system_demo.admin_hibernate.dao;

import com.example.quiz_system_demo.admin_hibernate.domain.HibernateQuizType;

import java.util.List;

public interface HibernateQuizTypeDAO {
    List<HibernateQuizType> findAll();

    String getQuizTypeById(Integer quizTypeId);
}
