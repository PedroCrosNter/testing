package app.block5crudValidation.content.teacher.infrastructure.repository.impl;

import app.block5crudValidation.content.teacher.domain.repository.DeleteTeacherRepository;
import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.TeacherRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeleteTeacherRepositoryImpl implements DeleteTeacherRepository {

    private final TeacherRepositoryJpa teacherRepositoryJpa;


    @Override
    public void delete(Long idTeacher) {
        teacherRepositoryJpa.deleteById(idTeacher);
    }
}
