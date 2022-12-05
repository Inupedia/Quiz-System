package com.example.quiz_system_demo.admin_hibernate.dao.impl;

import com.example.quiz_system_demo.admin_hibernate.dao.AbstractHibernateDAO;
import com.example.quiz_system_demo.admin_hibernate.dao.HibernateQuizTypeDAO;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateQuizType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("hibernateQuizTypeDAO")
public class HibernateQuizTypeDAOImpl extends AbstractHibernateDAO<HibernateQuizType> implements HibernateQuizTypeDAO {
    public HibernateQuizTypeDAOImpl() {
        setClazz(HibernateQuizType.class);
    }

    @Override
    public List<HibernateQuizType> findAll() {
        return getCurrentSession().createQuery("from HibernateQuizType").list();
    }

    @Override
    public String getQuizTypeById(Integer quizTypeId) {
        return getCurrentSession().createQuery("select description from HibernateQuizType where id = :id")
                .setParameter("id", quizTypeId).uniqueResult().toString();
    }
}
