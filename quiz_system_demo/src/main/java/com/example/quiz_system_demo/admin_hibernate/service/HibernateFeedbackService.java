package com.example.quiz_system_demo.admin_hibernate.service;

import com.example.quiz_system_demo.admin_hibernate.dao.HibernateFeedbackDAO;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateFeedback;
import com.example.quiz_system_demo.admin_hibernate.domain.dto.ReviewTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HibernateFeedbackService {

    private HibernateFeedbackDAO feedbackDAO;

    @Autowired
    @Qualifier("hibernateFeedbackDAO")
    public void setFeedbackDAO(HibernateFeedbackDAO feedbackDAO) {
        this.feedbackDAO = feedbackDAO;
    }

    @Transactional
    public List<HibernateFeedback> findAll() {
        return feedbackDAO.findAll();
    }
}
