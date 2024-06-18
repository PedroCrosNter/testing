package app.block5crudValidation.content.student.application;

import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.subject.domain.entity.Subject;

import java.util.List;

public interface RetrieveStudentUseCase {

    Student find(Long idStudent) throws EntityNotFoundException;

    List<Student> findAll();

    List<Subject> findSubjectsByIdStudent(Long idStudent);
}
