package com.example.quiz_system_demo.admin_hibernate.dao.impl;

import com.example.quiz_system_demo.admin_hibernate.dao.AbstractHibernateDAO;
import com.example.quiz_system_demo.admin_hibernate.dao.HibernateSubmissionDAO;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateSubmission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("hibernateSubmissionDAO")
public class HibernateSubmissionDAOImpl extends AbstractHibernateDAO<HibernateSubmission> implements HibernateSubmissionDAO {
    public HibernateSubmissionDAOImpl() {
        setClazz(HibernateSubmission.class);
    }


    @Override
    public List<HibernateSubmission> findAll() {
        // find all submissions base on descending order of submission date
        return getCurrentSession().createQuery("from HibernateSubmission order by date desc").list();
    }

    @Override
    public List<HibernateSubmission> findSubmissionByUserId(Integer id) {
        return getCurrentSession().createQuery("from HibernateSubmission where userId = :id")
                .setParameter("id", id).list();
    }


}
