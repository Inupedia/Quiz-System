package com.example.quiz_system_demo.controller;

import com.example.quiz_system_demo.domain.CurrentQuiz;
import com.example.quiz_system_demo.domain.Option;
import com.example.quiz_system_demo.domain.Question;
import com.example.quiz_system_demo.domain.QuizResult;
import com.example.quiz_system_demo.service.ResultService;
import com.example.quiz_system_demo.service.SubmissionService;
import com.example.quiz_system_demo.utils.UserUtilSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class SubmissionController {

    private SubmissionService submissionService;

    private ResultService resultService;

    @Autowired
    SubmissionController(SubmissionService submissionService, ResultService resultService) {
        this.submissionService = submissionService;
        this.resultService = resultService;
    }

    private List<QuizResult> data;

    private int score;

    private int totalScore;

    @RequestMapping(value = "/submission", method = RequestMethod.POST)
    public String postSubmission(@RequestParam HashMap<String, String> map) {

        data = new ArrayList<>();

        totalScore = map.size();

        UserUtilSingleton.getInstance().getUserUtil().setEndTime(new Timestamp(new Date().getTime()));

        score = 0;
        for (String key : map.keySet()) {
            int questionId = Integer.parseInt(key);
            if (UserUtilSingleton.getInstance().getUserUtil().isCorrect(questionId, map.get(key))) {
                score++;
            }
            QuizResult quizResult = QuizResult.builder()
                    .index(questionId)
                    .userAnswer(map.get(key))
                    .build();
            data.add(quizResult);
        }

        int userId = UserUtilSingleton.getInstance().getUserUtil().getCurrentUserId();
        int quizTypeId = UserUtilSingleton.getInstance().getUserUtil().getCurrentQuizTypeId();
        Timestamp startTime = UserUtilSingleton.getInstance().getUserUtil().getStartTime();
        Timestamp endTime = UserUtilSingleton.getInstance().getUserUtil().getEndTime();


        if (score >= submissionService.getScoreByUserIdAndQuizTypeId(userId, quizTypeId)) {

            // if submission id exists, we want to clear previous submission
            int currentSubmissionId = submissionService.getSubmissionIdByUserIdAndQuizTypeId(userId, quizTypeId);

            if (currentSubmissionId != 0) {
                resultService.deleteResultBySubmissionId(currentSubmissionId);
                submissionService.deleteSubmissionByUserIdAndQuizTypeId(userId, quizTypeId);
            }

            submissionService.insertSubmission(userId, quizTypeId, score, startTime, endTime);

            for(String key : map.keySet()) {
                int questionId = Integer.parseInt(key);
                resultService.insertResult(submissionService.getSubmissionIdByUserIdAndQuizTypeId(userId, quizTypeId), questionId, map.get(key));
            }
        }

        return "redirect:/submission";
    }

    @RequestMapping(value = "/submission", method = RequestMethod.GET)
    public String getSubmission(Model model) {
        for (QuizResult quizResult : data) {
            for (CurrentQuiz currentQuiz : UserUtilSingleton.getInstance().getUserUtil().getCurrentQuizList()) {
                if (quizResult.getIndex() == currentQuiz.getQuestion().getId()) {
                    quizResult.setOptions(currentQuiz.getOptions());
                    quizResult.setQuestion(currentQuiz.getQuestion());
                }
            }
            quizResult.setIndex(data.indexOf(quizResult) + 1);
        }

        System.out.println("getSubmission");

        model.addAttribute("data", data);

        model.addAttribute("score", score);

        model.addAttribute("totalScore", totalScore);

        model.addAttribute("quizTypeId", UserUtilSingleton.getInstance().getUserUtil().getCurrentQuizTypeId());

        return "submission";
    }

}
