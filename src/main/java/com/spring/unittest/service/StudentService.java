package com.spring.unittest.service;

import com.spring.unittest.model.Student;
import com.spring.unittest.repository.StudentRepository;
import com.spring.unittest.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int  studentId) {
        Optional<Student> student =  studentRepository.findById(studentId);
        if(student.isPresent()){
            Student retrieveStudent = student.get();
            return retrieveStudent;
        }
        else {
            return null;
        }
    }

    public List<Student> getStudentByName(String studentName) {
        return studentRepository.findByName(studentName);
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);


    }
}
