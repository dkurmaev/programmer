package dankur.schuele.demo.repository;


import dankur.schuele.demo.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    // Методы для работы с учителями
}
