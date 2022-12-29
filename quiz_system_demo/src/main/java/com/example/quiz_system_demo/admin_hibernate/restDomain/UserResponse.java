package com.example.quiz_system_demo.admin_hibernate.restDomain;

import com.example.quiz_system_demo.admin_hibernate.domain.HibernateUser;

import lombok.*;

@Getter
@Setter
@Builder
public class UserResponse {
    private ResponseStatus status;
    private HibernateUser user;

    @Override
    public String toString() {
        return "[user: " + user + "]";
    }
}
