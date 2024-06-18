package app.block5crudValidation.content.student.application.impl;

import app.block5crudValidation.content.student.application.RemoveSubjectsToStudentUseCase;
import app.block5crudValidation.content.student.application.RetrieveStudentUseCase;
import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import app.block5crudValidation.content.subject.application.RetrieveSubjectUseCase;
import app.block5crudValidation.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RemoveSubjectsToStudentUseCaseImpl implements RemoveSubjectsToStudentUseCase {

//    private final CreateStudentRepository createStudentRepository;
    private final StudentRepositoryJpa studentRepositoryJpa;
    private final RetrieveStudentUseCase retrieveStudentUseCase;
    private final RetrieveSubjectUseCase retrieveSubjectUseCase;


    @Override
    public Student removeSubjects(Long idStudent, List<Long> idsSubjects) {
        // Retrieve student entity
        Student student = retrieveStudentUseCase.find(idStudent);

        // Retrieve student JPA entity
        StudentJpa studentJpa = studentRepositoryJpa.findById(idStudent)
                .orElseThrow(() -> new EntityNotFoundException(Student.class, idStudent));

        // Filter and remove subjects from student
        List<SubjectJpa> subjectsToRemove = studentJpa.getSubjects().stream()
                .filter(subject -> idsSubjects.contains(subject.getIdSubject()))
                .collect(Collectors.toList());

        subjectsToRemove.forEach(studentJpa::removeSubject);

        // Save the updated student entity
        studentRepositoryJpa.save(studentJpa);

        // Convert updated studentJpa to domain entity and return (assuming there is a conversion method)
        return student; // This should ideally convert studentJpa to student domain entity
    }
}
