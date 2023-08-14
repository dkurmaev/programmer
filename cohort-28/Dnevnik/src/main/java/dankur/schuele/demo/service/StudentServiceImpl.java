package dankur.schuele.demo.service;

import dankur.schuele.demo.model.Student;
import dankur.schuele.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        // Добавьте логику создания ученика, например, сохранение в базе данных
        return studentRepository.save(student);
    }

    // Добавьте реализацию других методов интерфейса
}
