package com.example.quiz_system_demo.admin_hibernate.dao;

import com.example.quiz_system_demo.admin_hibernate.domain.HibernateSubmission;

import java.util.List;

public interface HibernateSubmissionDAO {

    List<HibernateSubmission> findAll();
}
