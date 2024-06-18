package app.block5crudValidation.content.teacher.application;

import app.block5crudValidation.content.teacher.infrastructure.controller.dto.input.TeacherCreateInputDto;

public interface CreateTeacherUseCase {

    Long save(TeacherCreateInputDto teacherCreateInputDto);
}
