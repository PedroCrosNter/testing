package app.block5crudValidation.content.teacher.application.mapper.impl;

import app.block5crudValidation.content.person.application.RetrievePersonUseCase;
import app.block5crudValidation.content.person.application.mapper.PersonEntityMapper;
import app.block5crudValidation.content.teacher.application.mapper.TeacherEntityMapper;
import app.block5crudValidation.content.teacher.application.mapper.TeacherForeignEntityMapper;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherForeignEntityMapperImpl implements TeacherForeignEntityMapper {

    private final RetrievePersonUseCase retrievePersonUseCase;


    @Override
    public TeacherJpa toEntityJpa(Teacher teacher) {

        TeacherJpa teacherJpa = TeacherEntityMapper.INSTANCE.toEntityJpa(teacher);

        teacherJpa.setPersonJpa(
                PersonEntityMapper.INSTANCE.toEntityJpa(
                        retrievePersonUseCase.find(
                                    teacher
                                        .getPerson()
                                        .getIdPerson()
                        )
                )
        );

        return teacherJpa;
    }
}
