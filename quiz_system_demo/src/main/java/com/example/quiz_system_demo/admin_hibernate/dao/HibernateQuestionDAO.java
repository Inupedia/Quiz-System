package com.example.quiz_system_demo.admin_hibernate.dao;

import com.example.quiz_system_demo.admin_hibernate.domain.HibernateQuestion;

public interface HibernateQuestionDAO {
    HibernateQuestion getQuestionById(Integer questionId);
}
