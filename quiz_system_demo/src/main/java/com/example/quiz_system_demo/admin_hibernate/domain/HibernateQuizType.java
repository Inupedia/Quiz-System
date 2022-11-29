package com.example.quiz_system_demo.admin_hibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "quizType")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HibernateQuizType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_type_id")
    private Integer quizTypeId;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "description")
    private String description;

    @Column(name = "time_limit")
    private Integer timeLimit;

}
