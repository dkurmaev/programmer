package com.example.dankur.schuele.demo.event.handler;

import com.example.dankur.schuele.demo.event.TeacherCreatedEvent;
import org.springframework.context.event.EventListener;

public class TeacherCreatedEventHandler {
    @EventListener
    public void handleTeacherCreatedEvent(TeacherCreatedEvent event) {
        System.out.println("Teacher created: " + event.getTeacher().getName());

    }
}
