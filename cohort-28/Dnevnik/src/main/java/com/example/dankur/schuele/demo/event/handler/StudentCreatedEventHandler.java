package com.example.dankur.schuele.demo.event.handler;

import com.example.dankur.schuele.demo.event.StudentCreatedEvent;
import org.springframework.context.event.EventListener;

public class StudentCreatedEventHandler {
    @EventListener
    public void handleStudentCreatedEvent(StudentCreatedEvent event) {
        System.out.println("Student created: " + event.getStudent().getName());
    }
}
