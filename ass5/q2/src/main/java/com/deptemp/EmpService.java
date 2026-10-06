package com.deptemp;

import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmpService {
    private List<Employee> list = new ArrayList<>();

    @PostConstruct
    public void init() {
        list.add(new Employee(101, "Rahul", "Developer", "IT", 50000));
        list.add(new Employee(102, "Priya", "Tester", "IT", 40000));
        list.add(new Employee(103, "Amit", "HR Manager", "HR", 60000));
        list.add(new Employee(104, "Sneha", "Recruiter", "HR", 45000));
        list.add(new Employee(105, "Vikram", "Accountant", "Finance", 48000));
        list.add(new Employee(106, "Neha", "Analyst", "Finance", 52000));
    }

    public List<Employee> byDept(String dept) {
        return list.stream()
                .filter(e -> e.getDeptName().equalsIgnoreCase(dept))
                .collect(Collectors.toList());
    }

    public List<Employee> getAll() { return list; }

    public Employee add(Employee emp) {
        list.add(emp);
        return emp;
    }

    public Set<String> getDepts() {
        return list.stream().map(Employee::getDeptName).collect(Collectors.toSet());
    }
}
