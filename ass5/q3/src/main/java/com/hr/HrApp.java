package com.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HrApp {
    public static void main(String[] args) {
        SpringApplication.run(HrApp.class, args);
        System.out.println("HR: http://localhost:8083/api/hr");
    }
}
