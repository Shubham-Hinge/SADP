package com.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApp {
    public static void main(String[] args) {
        SpringApplication.run(StudentApp.class, args);
        System.out.println("Student Service: http://localhost:8081/api/students");
    }
}
