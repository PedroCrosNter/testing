package app.block5crudValidation.content.teacher.infrastructure.repository.impl;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.shared.exceptions.ForeignKeyException;
import app.block5crudValidation.content.teacher.application.mapper.TeacherForeignEntityMapper;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.content.teacher.domain.repository.CreateTeacherRepository;
import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.TeacherRepositoryJpa;
import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreateTeacherRepositoryImpl implements CreateTeacherRepository {

    private final TeacherRepositoryJpa teacherRepositoryJpa;
    private final TeacherForeignEntityMapper teacherForeignEntityMapper;


    @Override
    public Long save(Teacher teacher) {
        // We can validate here
//        TeacherJpa teacherJpa = TeacherEntityMapper.INSTANCE.toEntityJpa(teacher);

//        return teacherRepositoryJpa.save(
//                teacherForeignEntityMapper.toEntityJpa(teacher)
//        ).getIdTeacher();

        TeacherJpa teacherJpa = teacherForeignEntityMapper.toEntityJpa(teacher);

        Long idTeacher = null;
        try {
            idTeacher = teacherRepositoryJpa.save(teacherJpa).getIdTeacher();
        } catch (Exception e) {
            throw new ForeignKeyException(Teacher.class, null, Person.class, teacher.getPerson().getIdPerson());
        }

        return idTeacher;
    }
}
