package com.student;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StudentService {
    private Map<Integer, Student> students = new HashMap<>();
    private int nextId = 1;

    public Student add(Student s) {
        s.setId(nextId++);
        students.put(s.getId(), s);
        return s;
    }

    public List<Student> getAll() { return new ArrayList<>(students.values()); }
    public Student get(int id) { return students.get(id); }

    public Student update(int id, Student u) {
        Student e = students.get(id);
        if (e != null) {
            e.setName(u.getName());
            e.setEmail(u.getEmail());
            e.setCourse(u.getCourse());
            e.setYear(u.getYear());
            e.setPhone(u.getPhone());
        }
        return e;
    }

    public boolean delete(int id) { return students.remove(id) != null; }
}
