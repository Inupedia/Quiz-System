package com.example.quiz_system_demo.admin_hibernate.dao;

import com.example.quiz_system_demo.admin_hibernate.domain.HibernateFeedback;
import com.example.quiz_system_demo.admin_hibernate.domain.dto.ReviewTable;

import java.util.List;

public interface HibernateFeedbackDAO {
    List<HibernateFeedback> findAll();
}
