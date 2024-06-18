package app.block5crudValidation.content.teacher.application;

import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;

import java.util.List;

public interface RetrieveTeacherUseCase {

    Teacher find(Long idTeacher) throws EntityNotFoundException;

    List<Teacher> findAll() throws EntityNotFoundException;
}
