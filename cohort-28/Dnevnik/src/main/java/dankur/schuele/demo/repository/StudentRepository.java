package dankur.schuele.demo.repository;

import dankur.schuele.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Методы для работы с учениками
}
