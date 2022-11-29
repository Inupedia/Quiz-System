package com.example.quiz_system_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class QuizSystemDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizSystemDemoApplication.class, args);
    }

}
