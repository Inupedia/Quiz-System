package com.example.quiz_system_demo.admin_hibernate.dao;

import com.example.quiz_system_demo.admin_hibernate.domain.HibernateUser;

import java.util.List;

public interface HibernateUserDAO {

    HibernateUser getUserById(Integer id);
    List<HibernateUser> findAll();

    void addUser(HibernateUser hibernateUser);

    void updateUser(HibernateUser hibernateUser);

    void deleteUser(Integer id);
}
