package app.block5crudValidation.content.student.application;

import app.block5crudValidation.content.student.domain.entity.Student;

import java.util.List;

public interface AddSubjectsToStudentUseCase {

    Student addSubjects(Long idStudent, List<Long> idsSubjects);
}
