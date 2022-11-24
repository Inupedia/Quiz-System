package com.example.quiz_system_demo.controller;

import com.example.quiz_system_demo.domain.CurrentQuiz;
import com.example.quiz_system_demo.domain.Option;
import com.example.quiz_system_demo.domain.Question;
import com.example.quiz_system_demo.service.OptionService;
import com.example.quiz_system_demo.service.QuestionService;
import com.example.quiz_system_demo.utils.UserUtilSingleton;
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

    @Autowired
    private QuestionService questionService;
    @Autowired
    private OptionService optionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getQuiz(@RequestParam("quizTypeId") int id, Model model) {
        int numOfQuestions = 2;
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
//        data.add(Data.builder()
//                .question(new Question(1, "Multiple Choice", "What is the capital of India?", "New Delhi", 1))
//                .options(new ArrayList<Option>() {{
//                    add(new Option(1, "New Delhi", 1));
//                    add(new Option(2, "Mumbai", 1));
//                    add(new Option(3, "Kolkata", 1));
//                    add(new Option(4, "Chennai", 1));
//                }})
//                .build());
        model.addAttribute("data", data);
        return "quiz";
    }

}



