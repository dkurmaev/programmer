package dankur.schuele.demo.service;

import dankur.schuele.demo.model.Teacher;
import dankur.schuele.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        // Добавьте логику создания учителя, например, сохранение в базе данных
        return teacherRepository.save(teacher);
    }

    // Добавьте реализацию других методов интерфейса
}
