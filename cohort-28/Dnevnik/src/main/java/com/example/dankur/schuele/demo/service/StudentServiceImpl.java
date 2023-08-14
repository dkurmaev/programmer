package com.example.dankur.schuele.demo.service;

import com.example.dankur.schuele.demo.event.StudentCreatedEvent;
import com.example.dankur.schuele.demo.model.Student;
import com.example.dankur.schuele.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, ApplicationEventPublisher eventPublisher) {
        this.studentRepository = studentRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Student createStudent(Student student) {
        Student currentStudent = studentRepository.save(student);
        eventPublisher.publishEvent(new StudentCreatedEvent(this, currentStudent));
        return studentRepository.save(student);
    }

    // Добавьте реализацию других методов интерфейса
}
