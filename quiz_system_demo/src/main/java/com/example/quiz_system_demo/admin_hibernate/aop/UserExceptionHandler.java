package com.example.quiz_system_demo.admin_hibernate.aop;

import com.example.quiz_system_demo.admin_hibernate.exception.UserNotFoundException;
import com.example.quiz_system_demo.admin_hibernate.restDomain.ResponseStatus;
import com.example.quiz_system_demo.admin_hibernate.restDomain.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

//    @ExceptionHandler(value = {UserNotFoundException.class})
//    public UserResponse handleUserNotFoundException(UserNotFoundException e) {
//        return UserResponse.builder()
//                .status(ResponseStatus.builder()
//                        .success(false)
//                        .message(e.getMessage())
//                        .build())
//                .user(null)
//                .build();
//    }

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<UserResponse> handleUserNotFoundException(UserNotFoundException e) {
        return new ResponseEntity(UserResponse.builder()
                .status(ResponseStatus.builder()
                        .success(false)
                        .message(e.getMessage())
                        .build())
                .user(null)
                .build(), HttpStatus.OK);
    }

}
