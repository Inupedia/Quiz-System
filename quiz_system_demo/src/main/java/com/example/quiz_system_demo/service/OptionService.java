package com.example.quiz_system_demo.service;

import com.example.quiz_system_demo.dao.OptionDAO;
import com.example.quiz_system_demo.domain.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {

    private final OptionDAO optionDAO;

    @Autowired
    public OptionService(OptionDAO optionDAO) {
        this.optionDAO = optionDAO;
    }

    public List<Option> getOptionsByQuestionId(int questionId) {
        return optionDAO.getOptionsByQuestionId(questionId);
    }
}
