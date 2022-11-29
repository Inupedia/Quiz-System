package com.example.quiz_system_demo.admin_hibernate.service;

import com.example.quiz_system_demo.admin_hibernate.dao.HibernateOptionDAO;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HibernateOptionService {

    private HibernateOptionDAO optionDAO;

    @Autowired
    @Qualifier("hibernateOptionDAO")

    public void setOptionDAO(HibernateOptionDAO optionDAO) {
        this.optionDAO = optionDAO;
    }

    @Transactional
    public List<HibernateOption> getOptionByQuestionId(Integer questionId) {
        return optionDAO.getOptionByQuestionId(questionId);
    }
}
