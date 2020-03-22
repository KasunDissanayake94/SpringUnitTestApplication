package com.spring.unittest.controller;

import com.spring.unittest.model.Student;
import com.spring.unittest.repository.StudentRepository;
import com.spring.unittest.service.StudentService;
import http.responce.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @GetMapping("/get/students/all")
    public ResponseEntity<ApiResponse> getAllStudents(){

        return ResponseEntity.ok().body(ApiResponse
                .success(ApiResponse.ApiStatus.S2000)
                .payload(studentService.getAllStudents()));
    }

    @GetMapping("/get/studentID/{studentId}")
    public ResponseEntity<ApiResponse> getStudentById(@PathVariable(value = "studentId") int studentId){
        return ResponseEntity.ok().body(ApiResponse
                .success(ApiResponse.ApiStatus.S2000)
                .payload(studentService.getAllStudents()));
    }

    @GetMapping("/get/studentName/{studentName}")
    public List<Student> getStudentById(@PathVariable(value = "studentName") String studentName){
        return studentService.getStudentByName(studentName);
    }



}
