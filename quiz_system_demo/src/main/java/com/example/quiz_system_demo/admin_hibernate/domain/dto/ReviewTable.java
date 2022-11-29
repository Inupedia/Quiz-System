package com.example.quiz_system_demo.admin_hibernate.domain.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ReviewTable {
    private Integer id;
    private String type;
    private Integer rate;
    private String comment;
}
