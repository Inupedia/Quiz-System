package com.example.quiz_system_demo.controller;

import com.example.quiz_system_demo.service.QuizTypeService;
import com.example.quiz_system_demo.utils.UserUtilSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.Calendar;
import java.util.HashMap;


@Controller
public class HomeController {

    private final QuizTypeService quizTypeService;

    @Autowired
    public HomeController(QuizTypeService quizTypeService) {
        this.quizTypeService = quizTypeService;
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getAllQuizTypes(Model model) {
        model.addAttribute("quizTypeList", quizTypeService.getAllQuizTypes());
        return "home";
    }

}
