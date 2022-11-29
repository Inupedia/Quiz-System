package com.example.quiz_system_demo.admin_hibernate.service;

import com.example.quiz_system_demo.admin_hibernate.dao.HibernateSubmissionDAO;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateSubmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HibernateSubmissionService {

    private HibernateSubmissionDAO submissionDAO;

    @Autowired
    @Qualifier("hibernateSubmissionDAO")
    public void setSubmissionDAO(HibernateSubmissionDAO submissionDAO) {
        this.submissionDAO = submissionDAO;
    }

    @Transactional
    public List<HibernateSubmission> findAll() {
        return submissionDAO.findAll();
    }
}
