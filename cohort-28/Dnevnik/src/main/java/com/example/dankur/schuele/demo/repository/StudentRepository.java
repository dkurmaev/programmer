package com.example.dankur.schuele.demo.repository;

import com.example.dankur.schuele.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);
    List<Student> findByGrade(String grade);
    List<Student> findByNameIgnoreCase(String name);


    // Методы для работы с учениками
}
