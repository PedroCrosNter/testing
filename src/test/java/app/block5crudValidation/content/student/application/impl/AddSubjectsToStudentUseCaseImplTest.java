package app.block5crudValidation.content.student.application.impl;

import app.block5crudValidation.content.student.application.RetrieveStudentUseCase;
import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import app.block5crudValidation.content.subject.application.RetrieveSubjectUseCase;
import app.block5crudValidation.content.subject.domain.entity.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class AddSubjectsToStudentUseCaseImplTest {

    @Mock
    private StudentRepositoryJpa studentRepositoryJpa;

    @Mock
    private RetrieveStudentUseCase retrieveStudentUseCase;

    @Mock
    private RetrieveSubjectUseCase retrieveSubjectUseCase;

    private AddSubjectsToStudentUseCaseImpl addSubjectsToStudentUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        addSubjectsToStudentUseCase = new AddSubjectsToStudentUseCaseImpl(studentRepositoryJpa, retrieveStudentUseCase, retrieveSubjectUseCase);
    }

    @Test
    void addSubjects() {
        // Given
        Student student = new Student();
        student.setIdStudent(1L);

        List<Long> subjectIds = new ArrayList<>();
        subjectIds.add(101L);
        subjectIds.add(102L);

        // Mocking behavior of RetrieveStudentUseCase to return the student
        when(retrieveStudentUseCase.find(anyLong())).thenReturn(student);

        // Mocking behavior of RetrieveSubjectUseCase to return subjects
        when(retrieveSubjectUseCase.findById(101L)).thenReturn(new Subject());
        when(retrieveSubjectUseCase.findById(102L)).thenReturn(new Subject());

        // Mocking behavior of StudentRepositoryJpa
        when(studentRepositoryJpa.save(any(StudentJpa.class))).thenReturn(new StudentJpa());

        // When
        Student result = addSubjectsToStudentUseCase.addSubjects(1L, subjectIds);

        // Then
        assertNotNull(result);
        verify(retrieveStudentUseCase).find(1L);
        verify(retrieveSubjectUseCase).findById(101L);
        verify(retrieveSubjectUseCase).findById(102L);
        verify(studentRepositoryJpa).save(any(StudentJpa.class));
    }
}
