package com.example.quiz_system_demo.admin_hibernate.restDomain;

import lombok.*;

@Builder
@Setter
@Getter
public class ResponseStatus {
    private boolean success;
    private String message;
}
