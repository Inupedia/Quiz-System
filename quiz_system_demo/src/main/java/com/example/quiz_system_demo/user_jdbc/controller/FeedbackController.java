package com.example.quiz_system_demo.user_jdbc.controller;

import com.example.quiz_system_demo.user_jdbc.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FeedbackController {

    private FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    public String getFeedback(@RequestParam("quizTypeId") int id, Model model) {
        model.addAttribute("quizTypeId", id);
        return "feedback";
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
//    @ResponseBody
//    public HashMap<String, String> getResult(HttpServletRequest request) {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("rating", request.getParameter("rating"));
//        map.put("feedback", request.getParameter("feedback"));
//        return map;
//    }
    public String getResult(@RequestParam("quizTypeId") int id, HttpServletRequest request) {
        feedbackService.insertFeedback(request.getParameter("rating"), request.getParameter("feedback"), id);
        return "feedbackResponse";
    }
}
