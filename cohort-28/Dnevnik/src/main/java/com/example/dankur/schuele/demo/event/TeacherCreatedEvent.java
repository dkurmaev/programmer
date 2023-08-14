package com.example.dankur.schuele.demo.event;

import com.example.dankur.schuele.demo.model.Teacher;
import org.springframework.context.ApplicationEvent;

public class TeacherCreatedEvent extends ApplicationEvent {
    private final Teacher teacher;

    public TeacherCreatedEvent(Object source, Teacher teacher) {
        super(source);
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
