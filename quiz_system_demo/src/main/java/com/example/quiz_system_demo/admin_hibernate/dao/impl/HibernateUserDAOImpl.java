package com.example.quiz_system_demo.admin_hibernate.dao.impl;

import com.example.quiz_system_demo.admin_hibernate.dao.AbstractHibernateDAO;
import com.example.quiz_system_demo.admin_hibernate.dao.HibernateUserDAO;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("hibernateUserDAO")
public class HibernateUserDAOImpl extends AbstractHibernateDAO<HibernateUser> implements HibernateUserDAO {

    public HibernateUserDAOImpl() {
        setClazz(HibernateUser.class);
    }
    @Override
    public HibernateUser getUserById(Integer id) {
        return findById(id);
    }

    @Override
    public List<HibernateUser> findAll() {
        return getCurrentSession().createQuery("from HibernateUser").list();
    }

    @Override
    public void addUser(HibernateUser hibernateUser) {
        add(hibernateUser);
    }

    @Override
    public void updateUser(HibernateUser hibernateUser) {
        update(hibernateUser);
    }
}

