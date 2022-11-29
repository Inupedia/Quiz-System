package com.example.quiz_system_demo.admin_hibernate.dao.impl;

import com.example.quiz_system_demo.admin_hibernate.dao.AbstractHibernateDAO;
import com.example.quiz_system_demo.admin_hibernate.dao.HibernateFeedbackDAO;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateFeedback;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("hibernateFeedbackDAO")
public class HibernateFeedbackDAOImpl extends AbstractHibernateDAO<HibernateFeedback> implements HibernateFeedbackDAO {
    public HibernateFeedbackDAOImpl() {
        setClazz(HibernateFeedback.class);
    }

    @Override
    public List<HibernateFeedback> findAll() {
        return getCurrentSession().createQuery("from HibernateFeedback").list();
    }
}
