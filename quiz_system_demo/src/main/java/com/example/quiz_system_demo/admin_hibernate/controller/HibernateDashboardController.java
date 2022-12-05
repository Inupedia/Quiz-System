package com.example.quiz_system_demo.admin_hibernate.controller;

import com.example.quiz_system_demo.admin_hibernate.domain.HibernateOption;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateQuestion;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateQuizType;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateUser;
import com.example.quiz_system_demo.admin_hibernate.domain.dto.QuizResult;
import com.example.quiz_system_demo.admin_hibernate.domain.dto.QuizTable;
import com.example.quiz_system_demo.admin_hibernate.domain.dto.ReviewTable;
import com.example.quiz_system_demo.admin_hibernate.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dashboard")
public class HibernateDashboardController {

    private HibernateUserService hibernateUserService;
    private HibernateSubmissionService hibernateSubmissionService;
    private HibernateResultService hibernateResultService;
    private HibernateQuizTypeService hibernateQuizTypeService;
    private HibernateQuestionService hibernateQuestionService;
    private HibernateOptionService hibernateOptionService;
    private HibernateFeedbackService hibernateFeedbackService;

    @Autowired
    public void setAllServices(HibernateUserService hibernateUserService,
                               HibernateSubmissionService hibernateSubmissionService,
                               HibernateResultService hibernateResultService,
                               HibernateQuizTypeService hibernateQuizTypeService,
                               HibernateQuestionService hibernateQuestionService,
                               HibernateOptionService hibernateOptionService,
                               HibernateFeedbackService hibernateFeedbackService) {
        this.hibernateUserService = hibernateUserService;
        this.hibernateSubmissionService = hibernateSubmissionService;
        this.hibernateResultService = hibernateResultService;
        this.hibernateQuizTypeService = hibernateQuizTypeService;
        this.hibernateQuestionService = hibernateQuestionService;
        this.hibernateOptionService = hibernateOptionService;
        this.hibernateFeedbackService = hibernateFeedbackService;
    }


//    @GetMapping("/{id}")
//    @ResponseBody
//    public String getUserById(@PathVariable Integer id) {
//        String res = hibernateUserService.getUserById(id).toString();
//        System.out.println(res);
//        return "<h1>hello</h1>";
//    }

    private List<QuizTable> getAllQuizzes() {
        List<QuizTable> quizResults = new ArrayList<>();
        List<HibernateQuizType> quizTypes = hibernateQuizTypeService.findAll();
        hibernateSubmissionService.findAll().forEach(submission -> {
            HibernateUser user = hibernateUserService.getUserById(submission.getUserId());
            QuizTable quizTable = new QuizTable();
            quizTable.setId(submission.getSubmissionId());
            quizTable.setDate(submission.getDate());
            quizTable.setFirstName(user.getFirstName());
            quizTable.setLastName(user.getLastName());
            quizTable.setScore(submission.getScore());
            quizTable.setType(quizTypes.get(submission.getQuizTypeId() - 1).getTypeName());
            quizResults.add(quizTable);
        });
        return quizResults;
    }

    private List<ReviewTable> getAllReviews() {
        List<ReviewTable> reviewTables = new ArrayList<>();
        List<HibernateQuizType> quizTypes = hibernateQuizTypeService.findAll();
        hibernateFeedbackService.findAll().forEach(feedback -> {
            ReviewTable reviewTable = new ReviewTable();
            reviewTable.setId(feedback.getFeedbackId());
            reviewTable.setComment(feedback.getComment());
            reviewTable.setRate(feedback.getRate());
            reviewTable.setType(quizTypes.get(feedback.getQuizTypeId() - 1).getTypeName());
            reviewTables.add(reviewTable);
        });
        return reviewTables;
    }

    @GetMapping
    public String setDashboard(Model model) {
        model.addAttribute("hibernateUser", new HibernateUser());
        model.addAttribute("users", hibernateUserService.findAll());
        model.addAttribute("quizTable", getAllQuizzes());
        model.addAttribute("reviewTable", getAllReviews());
//        System.out.println(getAllQuizzes());
        return "dashboard";
    }

    // add user into database by form
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("hibernateUser") HibernateUser hibernateUser) {
        hibernateUser.setIsAdmin(false);
        hibernateUser.setIsActive(true);
        hibernateUserService.addUser(hibernateUser);
        return "redirect:/dashboard#user";
    }

    @RequestMapping(value = "/getSubmission", method = RequestMethod.GET)
    public String getSubmission(@RequestParam("id") Integer id, Model model) {
        List<QuizResult> quizResults = new ArrayList<>();
        hibernateResultService.findBySubmissionId(id).forEach(result -> {
            List<HibernateOption> options = hibernateOptionService.getOptionByQuestionId(result.getQuestionId());
            HibernateQuestion question = hibernateQuestionService.getQuestionById(result.getQuestionId());
            QuizResult quizResult = new QuizResult();
            quizResult.setIndex(quizResults.size() + 1);
            quizResult.setUserAnswer(result.getUserChoice());
            quizResult.setQuestion(question);
            quizResult.setOptions(options);
            quizResults.add(quizResult);
        });
        model.addAttribute("data", quizResults);
        return "checkQuiz";
    }

    // update user by id
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public String updateUser(@RequestParam("uid") Integer id, @RequestBody MultiValueMap<String, String> formData) {
//        HibernateUser hibernateUser = new HibernateUser();
//        hibernateUser.setUserId(id);
//        hibernateUser.setFirstName(formData.getFirst("firstName"));
//        hibernateUser.setLastName(formData.getFirst("lastName"));
//        hibernateUser.setEmail(formData.getFirst("email"));
//        hibernateUser.setPhone(formData.getFirst("phone"));
//        hibernateUser.setAddress(formData.getFirst("address"));
//        hibernateUserService.updateUser(hibernateUser);
        for (Map.Entry<String, List<String>> entry : formData.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        return "redirect:/dashboard#user";
    }

    // delete user by id
    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    public String deleteUser(@RequestParam("id") Integer id) {
        hibernateUserService.deleteUser(id);
        return "redirect:/dashboard#user";
    }

}
