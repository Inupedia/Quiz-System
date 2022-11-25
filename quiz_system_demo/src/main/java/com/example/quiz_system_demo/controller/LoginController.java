package com.example.quiz_system_demo.controller;

import com.example.quiz_system_demo.domain.User;
import com.example.quiz_system_demo.service.UserService;
import com.example.quiz_system_demo.utils.UserUtilSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@RequestParam String email, @RequestParam String password, HttpServletRequest request) {
        Optional<User> user = userService.getUserByEmail(email);
        if (user.isPresent()) {
            if (userService.validateLogin(email, password)){
                System.out.println("Login successful");
                HttpSession oldSession = request.getSession(false);
                if (oldSession != null) {
                    oldSession.invalidate();
                }
                HttpSession newSession = request.getSession(true);
                newSession.setAttribute("user", user.get().getFirstName());
                UserUtilSingleton.getInstance().getUserUtil().setCurrentUserId(user.get().getUserId());
                return "redirect:/home";
            }
        }
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String password) {
        User user = User.builder()
                .firstName(firstname)
                .lastName(lastname)
                .email(email)
                .password(password)
                .build();
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String getLogout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login";
    }

}
