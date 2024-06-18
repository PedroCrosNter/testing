package app.block5crudValidation.content.teacher.domain.repository;

import app.block5crudValidation.content.teacher.domain.entity.Teacher;

public interface CreateTeacherRepository {

    Long save(Teacher teacher);
}
