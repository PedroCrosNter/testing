package app.block5crudValidation.content.student.application;

import app.block5crudValidation.content.student.infrastructure.controller.dto.input.StudentCreateInputDto;

public interface CreateStudentUseCase {

    Long save(StudentCreateInputDto studentCreateInputDto);
}
