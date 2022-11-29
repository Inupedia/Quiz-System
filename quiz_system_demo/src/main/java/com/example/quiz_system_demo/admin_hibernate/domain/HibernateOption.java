package com.example.quiz_system_demo.admin_hibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "`option`")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HibernateOption implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Integer optionId;

    @Column(name = "description")
    private String description;

    @Column(name = "question_id")
    private Integer questionId;
}
