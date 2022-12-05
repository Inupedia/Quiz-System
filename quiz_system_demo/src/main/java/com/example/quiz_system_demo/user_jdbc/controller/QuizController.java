package com.example.quiz_system_demo.user_jdbc.controller;

import com.example.quiz_system_demo.user_jdbc.domain.CurrentQuiz;
import com.example.quiz_system_demo.user_jdbc.domain.Option;
import com.example.quiz_system_demo.user_jdbc.domain.Question;
import com.example.quiz_system_demo.user_jdbc.service.OptionService;
import com.example.quiz_system_demo.user_jdbc.service.QuestionService;
import com.example.quiz_system_demo.user_jdbc.utils.UserUtilSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private QuestionService questionService;
    private OptionService optionService;
    @Autowired
    QuizController(QuestionService questionService, OptionService optionService) {
        this.questionService = questionService;
        this.optionService = optionService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getQuiz(@RequestParam("quizTypeId") int id, Model model) {
        int numOfQuestions = 3;
        List<CurrentQuiz> data = new ArrayList<>();
        List<Question> randomQuestions = questionService.getRandomQuestions(id, numOfQuestions);
        for (Question question : randomQuestions) {
            List<Option> options = optionService.getOptionsByQuestionId(question.getId());
            CurrentQuiz d = CurrentQuiz.builder()
                    .index(randomQuestions.indexOf(question) + 1)
                    .question(question)
                    .options(options)
                    .build();
            data.add(d);
        }

        UserUtilSingleton.getInstance().getUserUtil().setCurrentQuizList(data);
        UserUtilSingleton.getInstance().getUserUtil().setCurrentQuizTypeId(id);
        UserUtilSingleton.getInstance().getUserUtil().setStartTime(new Timestamp(new Date().getTime()));
        System.out.println(UserUtilSingleton.getInstance().getUserUtil());
        model.addAttribute("data", data);
        return "quiz";
    }

}



