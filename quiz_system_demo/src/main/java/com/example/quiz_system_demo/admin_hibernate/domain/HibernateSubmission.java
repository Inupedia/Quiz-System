package com.example.quiz_system_demo.admin_hibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "submission")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HibernateSubmission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "submission_id")
    private Integer submissionId;

    @Column
    private Integer score;

    @Column(name = "start_time")
    private Date date;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "quiz_type_id")
    private Integer quizTypeId;
}
