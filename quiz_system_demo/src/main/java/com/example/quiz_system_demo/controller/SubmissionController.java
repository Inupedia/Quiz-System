package com.example.quiz_system_demo.controller;

import com.example.quiz_system_demo.service.ResultService;
import com.example.quiz_system_demo.service.SubmissionService;
import com.example.quiz_system_demo.utils.UserUtilSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

@Controller
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private ResultService resultService;

    @RequestMapping(value = "/submission", method = RequestMethod.POST)
    public String postSubmission(@RequestParam HashMap<String, String> map) {
        UserUtilSingleton.getInstance().getUserUtil().setEndTime(new Timestamp(new Date().getTime()));
        int score = 0;
        for (String key : map.keySet()) {
            int questionId = Integer.parseInt(key);
            if (UserUtilSingleton.getInstance().getUserUtil().isCorrect(questionId, map.get(key))) {
                score++;
            }
        }

        int userId = UserUtilSingleton.getInstance().getUserUtil().getCurrentUserId();
        int quizTypeId = UserUtilSingleton.getInstance().getUserUtil().getCurrentQuizTypeId();
        Timestamp startTime = UserUtilSingleton.getInstance().getUserUtil().getStartTime();
        Timestamp endTime = UserUtilSingleton.getInstance().getUserUtil().getEndTime();


        if (score >= submissionService.getScoreByUserIdAndQuizTypeId(userId, quizTypeId)) {
            resultService.deleteResultBySubmissionId(submissionService.getSubmissionIdByUserIdAndQuizTypeId(userId, quizTypeId));

            submissionService.deleteSubmissionByUserIdAndQuizTypeId(userId, quizTypeId);
            submissionService.insertSubmission(userId, quizTypeId, score, startTime, endTime);

            for(String key : map.keySet()) {
                int questionId = Integer.parseInt(key);
                resultService.insertResult(submissionService.getSubmissionIdByUserIdAndQuizTypeId(userId, quizTypeId), questionId, map.get(key));
            }
        }

        return "submission";
    }

}
