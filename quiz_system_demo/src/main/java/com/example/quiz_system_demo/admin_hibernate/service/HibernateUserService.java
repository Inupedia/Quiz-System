package com.example.quiz_system_demo.admin_hibernate.service;

import com.example.quiz_system_demo.admin_hibernate.dao.HibernateUserDAO;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HibernateUserService {

    private HibernateUserDAO hibernateUserDAO;

    @Autowired
    @Qualifier("hibernateUserDAO")
    public void setUserDAO(HibernateUserDAO hibernateUserDAO) {
        this.hibernateUserDAO = hibernateUserDAO;
    }

    @Transactional
    public HibernateUser getUserById(Integer id) {
        return hibernateUserDAO.getUserById(id);
    }

    @Transactional
    public List<HibernateUser> findAll() {
        return hibernateUserDAO.findAll();
    }

    @Transactional
    public void addUser(HibernateUser hibernateUser) {
        hibernateUserDAO.addUser(hibernateUser);
    }

    @Transactional
    public void updateUser(HibernateUser hibernateUser) {
        hibernateUserDAO.updateUser(hibernateUser);
    }
}
