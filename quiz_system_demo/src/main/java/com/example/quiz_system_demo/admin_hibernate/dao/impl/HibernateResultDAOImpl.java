package com.example.quiz_system_demo.admin_hibernate.dao.impl;

import com.example.quiz_system_demo.admin_hibernate.dao.AbstractHibernateDAO;
import com.example.quiz_system_demo.admin_hibernate.dao.HibernateResultDAO;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("hibernateResultDAO")
public class HibernateResultDAOImpl extends AbstractHibernateDAO<HibernateResult> implements HibernateResultDAO {
    public HibernateResultDAOImpl() {
        setClazz(HibernateResult.class);
    }

    @Override
    public List<HibernateResult> findBySubmissionId(Integer id) {
        return getCurrentSession().createQuery("from HibernateResult where submission_id = :id").setParameter("id", id).list();
    }
}
