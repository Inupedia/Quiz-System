package com.example.quiz_system_demo.admin_hibernate.dao;

import com.example.quiz_system_demo.admin_hibernate.domain.HibernateOption;

import java.util.List;

public interface HibernateOptionDAO {
    List<HibernateOption> getOptionByQuestionId(Integer questionId);
}
