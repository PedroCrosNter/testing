package app.block5crudValidation.content.student.infrastructure.repository.impl;

import app.block5crudValidation.content.student.application.mapper.StudentEntityMapper;
import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.student.domain.repository.CreateStudentRepository;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreateStudentRepositoryImpl implements CreateStudentRepository {

    private final StudentRepositoryJpa studentRepositoryJpa;


    @Override
    public Long save(Student student) {
        StudentJpa studentJpa = StudentEntityMapper.INSTANCE.toEntityJpa(student);
        return studentRepositoryJpa.save(studentJpa).getIdStudent();
    }
}
