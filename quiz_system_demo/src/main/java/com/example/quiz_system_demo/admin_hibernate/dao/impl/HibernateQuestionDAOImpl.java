package com.example.quiz_system_demo.admin_hibernate.dao.impl;

import com.example.quiz_system_demo.admin_hibernate.dao.AbstractHibernateDAO;
import com.example.quiz_system_demo.admin_hibernate.dao.HibernateQuestionDAO;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateQuestion;
import org.springframework.stereotype.Repository;

@Repository("hibernateQuestionDAO")
public class HibernateQuestionDAOImpl extends AbstractHibernateDAO<HibernateQuestion> implements HibernateQuestionDAO {
    public HibernateQuestionDAOImpl() {
        setClazz(HibernateQuestion.class);
    }

    @Override
    public HibernateQuestion getQuestionById(Integer questionId) {
        return getCurrentSession().get(HibernateQuestion.class, questionId);
    }
}
