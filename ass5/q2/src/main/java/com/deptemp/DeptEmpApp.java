package com.deptemp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeptEmpApp {
    public static void main(String[] args) {
        SpringApplication.run(DeptEmpApp.class, args);
        System.out.println("Dept Emp: http://localhost:8082/api/employees/department/IT");
    }
}
