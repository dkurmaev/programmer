package com.example.dankur.schuele.demo.repository;


import com.example.dankur.schuele.demo.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findByName(String name);

    List<Teacher> findBySubject(String subject);
    List<Teacher> findByNameAndSubject(String name, String subject);
    List<Teacher> findByNameIgnoreCase(String name);

}
