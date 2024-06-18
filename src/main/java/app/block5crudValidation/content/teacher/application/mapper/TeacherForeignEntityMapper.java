package app.block5crudValidation.content.teacher.application.mapper;

import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;

public abstract interface TeacherForeignEntityMapper {

    TeacherJpa toEntityJpa(Teacher teacher);
}
