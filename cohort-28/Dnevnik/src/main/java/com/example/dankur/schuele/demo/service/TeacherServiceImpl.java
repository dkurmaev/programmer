package com.example.dankur.schuele.demo.service;

import com.example.dankur.schuele.demo.event.TeacherCreatedEvent;
import com.example.dankur.schuele.demo.model.Teacher;
import com.example.dankur.schuele.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.teacherRepository = teacherRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        Teacher createdTeacher = teacherRepository.save(teacher);
        eventPublisher.publishEvent(new TeacherCreatedEvent(this, createdTeacher));
        return createdTeacher;
    }

    // Добавьте реализацию других методов интерфейса
}
