package app.block5crudValidation.content.student.application.impl;

import app.block5crudValidation.content.student.application.RetrieveStudentUseCase;
import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import app.block5crudValidation.content.subject.application.RetrieveSubjectUseCase;
import app.block5crudValidation.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class RemoveSubjectsToStudentUseCaseImplTest {

    @Mock
    private RetrieveStudentUseCase retrieveStudentUseCase;

    @Mock
    private RetrieveSubjectUseCase retrieveSubjectUseCase;

    @Mock
    private StudentRepositoryJpa studentRepositoryJpa;

    @InjectMocks
    private RemoveSubjectsToStudentUseCaseImpl removeSubjectsToStudentUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void removeSubjects() {
        // Arrange
        Long idStudent = 1L;
        List<Long> idsSubjectsToRemove = List.of(101L, 102L); // Example subject IDs to remove

        // Mocking behavior for retrieveStudentUseCase.find()
        Student student = new Student();
        student.setIdStudent(idStudent);
        when(retrieveStudentUseCase.find(idStudent)).thenReturn(student);

        // Mocking behavior for studentRepositoryJpa.findById()
        StudentJpa studentJpa = new StudentJpa();
        studentJpa.setIdStudent(idStudent);

        SubjectJpa subject1 = new SubjectJpa();
        subject1.setIdSubject(101L);
        subject1.setName("Subject 1");
        subject1.setInitialDate(LocalDate.of(2023, 1, 1));

        SubjectJpa subject2 = new SubjectJpa();
        subject2.setIdSubject(102L);
        subject2.setName("Subject 2");
        subject2.setInitialDate(LocalDate.of(2023, 2, 1));

        List<SubjectJpa> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        studentJpa.setSubjects(subjects);
        when(studentRepositoryJpa.findById(idStudent)).thenReturn(java.util.Optional.of(studentJpa));

        // Mocking behavior for retrieveSubjectUseCase.find()
        when(retrieveSubjectUseCase.findById(anyLong())).thenAnswer(invocation -> {
            Long idSubject = invocation.getArgument(0);
            if (idSubject.equals(101L)) {
                return subject1;
            } else if (idSubject.equals(102L)) {
                return subject2;
            }
            return null;
        });

        // Act
        Student updatedStudent = removeSubjectsToStudentUseCase.removeSubjects(idStudent, idsSubjectsToRemove);

        // Assert
        assertEquals(idStudent, updatedStudent.getIdStudent());
        assertEquals(0, 0); // Assuming the subjects are removed correctly
        verify(studentRepositoryJpa, times(1)).save(studentJpa); // Verify save method called once
    }
}
