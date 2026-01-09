package com.uday.crudapp.controller;

import com.uday.crudapp.entity.Student;

import jakarta.validation.Valid;


import com.uday.crudapp.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentsController")
public class StudentController {

    private final StudentService studentService;

    // Constructor Injection (Best Practice)
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // ✅ CREATE
    @PostMapping("/createStudent")
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // ✅ READ ALL
    @GetMapping("/getStudent")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // ✅ READ BY ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }
}
