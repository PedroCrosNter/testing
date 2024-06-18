package app.block5crudValidation.content.student.infrastructure.repository.impl;

import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import app.block5crudValidation.content.student.application.mapper.StudentEntityMapper;
import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.student.domain.repository.UpdateStudentRepository;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UpdateStudentRepositoryImpl implements UpdateStudentRepository {

    private final StudentRepositoryJpa studentRepositoryJpa;


    @Override
    public Student update(Student student) {

        return studentRepositoryJpa
                .findById(student.getIdStudent())
                .map(existingStudentJpa -> {
                    // Map new data to EntityJpa
                    StudentEntityMapper.INSTANCE.toEntity(student, existingStudentJpa);
                    // Save new entity updated
                    return studentRepositoryJpa.save(existingStudentJpa);
                })
                // Map to Entity
                .map(StudentEntityMapper.INSTANCE::toEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException(Student.class, student.getIdStudent())
                );
    }
}
