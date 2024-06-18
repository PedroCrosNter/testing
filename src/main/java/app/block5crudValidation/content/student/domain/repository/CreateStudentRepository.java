package app.block5crudValidation.content.student.domain.repository;

import app.block5crudValidation.content.student.domain.entity.Student;

public interface CreateStudentRepository {

    Long save(Student student);
}
