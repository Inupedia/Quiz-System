package com.example.quiz_system_demo.admin_hibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "result")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HibernateResult implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Integer resultId;

    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "submission_id")
    private Integer submissionId;

    @Column(name = "user_choice")
    private String userChoice;
}
