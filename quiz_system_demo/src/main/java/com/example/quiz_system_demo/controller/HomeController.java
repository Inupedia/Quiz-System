package com.example.quiz_system_demo.controller;

import com.example.quiz_system_demo.domain.Data;
import com.example.quiz_system_demo.domain.Option;
import com.example.quiz_system_demo.domain.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String getHome(Model model) {
        List<Data> data = new ArrayList<>();
        data.add(Data.builder()
                .question(new Question(1, "Multiple Choice", "What is the capital of India?", "New Delhi", "1"))
                .answers(new ArrayList<Option>() {{
                    add(new Option(1, "New Delhi", "1"));
                    add(new Option(2, "Mumbai", "1"));
                    add(new Option(3, "Kolkata", "1"));
                    add(new Option(4, "Chennai", "1"));
                }})
                .build());
        model.addAttribute("data", data);
        return "home";
    }

}
