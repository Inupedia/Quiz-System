package com.example.quiz_system_demo.admin_hibernate.controller;

import com.example.quiz_system_demo.admin_hibernate.domain.HibernateOption;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateQuestion;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateQuizType;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateUser;
import com.example.quiz_system_demo.admin_hibernate.domain.dto.QuizResult;
import com.example.quiz_system_demo.admin_hibernate.exception.UserNotFoundException;
import com.example.quiz_system_demo.admin_hibernate.restDomain.*;
import com.example.quiz_system_demo.admin_hibernate.restDomain.ResponseStatus;
import com.example.quiz_system_demo.admin_hibernate.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/user")
public class RestUserController {
    private HibernateUserService hibernateUserService;
    private HibernateSubmissionService hibernateSubmissionService;
    private HibernateResultService hibernateResultService;
    private HibernateOptionService hibernateOptionService;
    private HibernateQuestionService hibernateQuestionService;
    private HibernateQuizTypeService hibernateQuizTypeService;


    @Autowired
    public void setAllServices(HibernateUserService hibernateUserService,
                               HibernateSubmissionService hibernateSubmissionService,
                               HibernateResultService hibernateResultService,
                               HibernateOptionService hibernateOptionService,
                               HibernateQuestionService hibernateQuestionService,
                               HibernateQuizTypeService hibernateQuizTypeService) {
        this.hibernateUserService = hibernateUserService;
        this.hibernateSubmissionService = hibernateSubmissionService;
        this.hibernateResultService = hibernateResultService;
        this.hibernateOptionService = hibernateOptionService;
        this.hibernateQuestionService = hibernateQuestionService;
        this.hibernateQuizTypeService = hibernateQuizTypeService;
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public AllUserResponse getAllUsers() {
        return AllUserResponse.builder()
                .status(ResponseStatus.builder()
                        .success(true)
                        .message("success")
                        .build())
                .users(hibernateUserService.findAll())
                .build();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseStatus addUser(@Valid @RequestBody UserRequest user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseStatus.builder()
                    .success(false)
                    .message(bindingResult.getAllErrors().get(0).getDefaultMessage())
                    .build();
        }
        HibernateUser newUser = HibernateUser.builder()
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .address(user.getAddress())
                        .phone(user.getPhone())
                        .isAdmin(false)
                        .isActive(true)
                        .build();
        hibernateUserService.addUser(newUser);
        return ResponseStatus.builder()
                .success(true)
                .message("success")
                .build();
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET, params = "userId")
    public UserResponse getUserById(@RequestParam("userId") Integer id) throws UserNotFoundException {
        HibernateUser user = hibernateUserService.getUserById(id);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return UserResponse.builder()
                .status(ResponseStatus.builder()
                        .success(true)
                        .message("success")
                        .build())
                .user(user)
                .build();
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE, params = "userId")
    public ResponseStatus deleteUser(@RequestParam("userId") Integer id) {
        hibernateUserService.deleteUser(id);
        return ResponseStatus.builder()
                .success(true)
                .message("success")
                .build();
    }

    //Switch isActive state
    @RequestMapping(value = "/user/{userId}/status", method = RequestMethod.PATCH, params = "activate")
    public ResponseStatus activateUser(@PathVariable("userId") Integer id, @RequestParam("activate") Boolean activate) {
        HibernateUser user = hibernateUserService.getUserById(id);
        user.setIsActive(activate);
        hibernateUserService.updateUser(user);
        return ResponseStatus.builder()
                .success(true)
                .message("success")
                .build();
    }

    // Get all quizzes done by a user given their userId
    @RequestMapping(value = "/quiz", method = RequestMethod.GET, params = "userId")
    public QuizResponse getQuizByUserId(@RequestParam("userId") Integer id) {
        List<AllQuizResult> quizResults = new ArrayList<>();
        hibernateSubmissionService.findSubmissionByUserId(id).forEach(
                submission -> {
                    List<QuizResult> quizResultList = new ArrayList<>();
                    hibernateResultService.findBySubmissionId(submission.getSubmissionId()).forEach(
                            result -> {
                                List<HibernateOption> options = hibernateOptionService.getOptionByQuestionId(result.getQuestionId());
                                HibernateQuestion question = hibernateQuestionService.getQuestionById(result.getQuestionId());
                                QuizResult quizResult = new QuizResult();
                                quizResult.setIndex(quizResults.size() + 1);
                                quizResult.setUserAnswer(result.getUserChoice());
                                quizResult.setQuestion(question);
                                quizResult.setOptions(options);
                                quizResultList.add(quizResult);
                            }
                    );
                    quizResults.add(AllQuizResult.builder()
                            .quizType(hibernateQuizTypeService.getQuizTypeById(submission.getQuizTypeId()))
                            .quizResults(quizResultList)
                            .build());
                }
        );
        return QuizResponse.builder()
                .status(ResponseStatus.builder()
                        .success(true)
                        .message("success")
                        .build())
                .quizResults(quizResults)
                .build();
    }

}
