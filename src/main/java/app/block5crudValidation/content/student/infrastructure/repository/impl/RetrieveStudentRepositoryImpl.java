package app.block5crudValidation.content.student.infrastructure.repository.impl;

import app.block5crudValidation.content.person.application.mapper.PersonEntityMapper;
import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import app.block5crudValidation.content.student.application.mapper.StudentEntityMapper;
import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.student.domain.repository.RetrieveStudentRepository;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import app.block5crudValidation.content.teacher.application.mapper.TeacherEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RetrieveStudentRepositoryImpl implements RetrieveStudentRepository {

    private final StudentRepositoryJpa studentRepositoryJpa;


    @Override
    public Student findById(Long idStudent) {

        if (!studentRepositoryJpa.existsById(idStudent)) {
            throw new EntityNotFoundException(Student.class, idStudent);
        }
        StudentJpa studentJpa = studentRepositoryJpa.findById(idStudent)
                .orElseThrow( () -> new EntityNotFoundException(Student.class, idStudent) );
        Student student = StudentEntityMapper.INSTANCE.toEntity(studentJpa);
        student.setPerson(
                PersonEntityMapper.INSTANCE.toEntity(studentJpa.getPersonJpa())
        );
        student.setTeacher(
                TeacherEntityMapper.INSTANCE.toEntity(studentJpa.getTeacherJpa())
        );


        return student;
    }

    @Override
    public List<Student> findAll() {
        List<StudentJpa> studentJpaList = studentRepositoryJpa.findAll();
        return studentJpaList.stream()
                .map(StudentEntityMapper.INSTANCE::toEntity)
                .collect(Collectors.toList());
    }
}
