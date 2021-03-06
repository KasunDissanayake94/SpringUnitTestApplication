package com.spring.unittest.repository;

import com.spring.unittest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student , Integer> {

    List<Student> findByName(String name);

    List<Student> findByEmail(String email);
}
