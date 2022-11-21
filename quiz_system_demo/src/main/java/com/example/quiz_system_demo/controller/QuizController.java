package com.example.quiz_system_demo.controller;

import com.example.quiz_system_demo.domain.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/api")
public class QuizController {

    @RequestMapping(value = "/submission", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, String> getResult() {
        HashMap<String, String> result = new HashMap<>();
        result.put("result", "success");
        return result;
    }
}



