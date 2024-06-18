package app.block5crudValidation.content.teacher.infrastructure.repository.jpa;

import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepositoryJpa extends JpaRepository<TeacherJpa, Long> {
}
