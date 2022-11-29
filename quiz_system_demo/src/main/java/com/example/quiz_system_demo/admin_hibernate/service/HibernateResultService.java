package com.example.quiz_system_demo.admin_hibernate.service;

import com.example.quiz_system_demo.admin_hibernate.dao.HibernateResultDAO;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateResult;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateSubmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HibernateResultService {

    private HibernateResultDAO resultDAO;

    @Autowired
    @Qualifier("hibernateResultDAO")
    public void setResultDAO(HibernateResultDAO resultDAO) {
        this.resultDAO = resultDAO;
    }

    @Transactional
    public List<HibernateResult> findBySubmissionId(Integer id) {
        return resultDAO.findBySubmissionId(id);
    }
}
