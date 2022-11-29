package com.example.quiz_system_demo.admin_hibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "question")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HibernateQuestion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "question_type")
    private String questionType;

    @Column(name = "description")
    private String description;

    @Column(name = "correct_answer")
    private String correctAnswer;

    @Column(name = "quiz_type_id")
    private Integer quizTypeId;
}
