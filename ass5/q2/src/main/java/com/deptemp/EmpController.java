package com.deptemp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/employees")
public class EmpController {
    @Autowired
    private EmpService service;

    @GetMapping("/department/{deptName}")
    public List<Employee> byDept(@PathVariable String deptName) {
        return service.byDept(deptName);
    }

    @GetMapping
    public List<Employee> all() { return service.getAll(); }

    @GetMapping("/departments")
    public Set<String> depts() { return service.getDepts(); }

    @PostMapping
    public Employee add(@RequestBody Employee emp) { return service.add(emp); }
}
