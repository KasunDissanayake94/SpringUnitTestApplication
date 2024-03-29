package com.spring.unittest.controller;

import com.spring.unittest.model.Student;
import com.spring.unittest.repository.StudentRepository;
import com.spring.unittest.service.StudentService;
import http.responce.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println("came");
        return studentService.saveStudent(student);
    }

    @GetMapping("/get/students/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/get/students/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "studentId") int studentId){
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/get/students/{studentName}")
    public ResponseEntity<List<Student>> getStudentById(@PathVariable(value = "studentName") String studentName){
        return studentService.getStudentByName(studentName);
    }

    @PutMapping("/students/{studentId}")
    public ResponseEntity<Student> updateStudentDetails(@PathVariable("id") String studentId, @RequestBody Student student){
        return studentService.updateStudentDetails(studentId, student);

    }

    @DeleteMapping("/inventories/{studentId}")
    public ResponseEntity<HttpStatus> deleteInventory(int studentId) {
        return studentService.deleteStudent(studentId);

    }

    @DeleteMapping("/inventories")
    public ResponseEntity<HttpStatus> deleteAllInventories() {
        return studentService.deleteAllStudents();

    }

}
