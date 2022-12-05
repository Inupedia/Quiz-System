package com.example.quiz_system_demo.admin_hibernate.restDomain;

import com.example.quiz_system_demo.admin_hibernate.domain.HibernateUser;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
public class AllUserResponse {
    private ResponseStatus status;
    private List<HibernateUser> users;
}
