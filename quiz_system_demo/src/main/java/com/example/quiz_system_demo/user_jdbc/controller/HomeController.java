package com.example.quiz_system_demo.user_jdbc.controller;

import com.example.quiz_system_demo.user_jdbc.service.QuizTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

//    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
//    public String getDashboard() {
//        return "dashboard";
//    }

}
