package com.example.quiz_system_demo.admin_hibernate.dao.impl;

import com.example.quiz_system_demo.admin_hibernate.dao.AbstractHibernateDAO;
import com.example.quiz_system_demo.admin_hibernate.dao.HibernateOptionDAO;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateOption;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("hibernateOptionDAO")
public class HibernateOptionDAOImpl extends AbstractHibernateDAO<HibernateOption> implements HibernateOptionDAO {
    public HibernateOptionDAOImpl() {
        setClazz(HibernateOption.class);
    }

    @Override
    public List<HibernateOption> getOptionByQuestionId(Integer questionId) {
        String hql = "from HibernateOption where question_id = :questionId";
        return getCurrentSession().createQuery(hql).setParameter("questionId", questionId).list();
    }
}
