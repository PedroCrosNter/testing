package app.block5crudValidation.content.subject.infrastructure.repository.impl;

import app.block5crudValidation.content.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import app.block5crudValidation.content.subject.domain.entity.Subject;
import app.block5crudValidation.content.subject.infrastructure.repository.jpa.SubjectRepositoryJpa;
import app.block5crudValidation.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RetrieveSubjectRepositoryImplTest {

    @Mock
    private SubjectRepositoryJpa subjectRepositoryJpa;

    @Mock
    private StudentRepositoryJpa studentRepositoryJpa;

    @InjectMocks
    private RetrieveSubjectRepositoryImpl retrieveSubjectRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById_shouldReturnSubject_whenFound() {
        // Given
        Long idSubject = 1L;
        SubjectJpa subjectJpa = new SubjectJpa();
        subjectJpa.setIdSubject(idSubject);
        when(subjectRepositoryJpa.findById(idSubject)).thenReturn(Optional.of(subjectJpa));

        // When
        Subject subject = retrieveSubjectRepository.findById(idSubject);

        // Then
        assertNotNull(subject);
        assertEquals(idSubject, subject.getIdSubject());
        verify(subjectRepositoryJpa, times(1)).findById(idSubject);
    }

    @Test
    void findById_shouldThrowException_whenNotFound() {
        // Given
        Long idSubject = 1L;
        when(subjectRepositoryJpa.findById(idSubject)).thenReturn(Optional.empty());

        // When / Then
        assertThrows(EntityNotFoundException.class, () -> retrieveSubjectRepository.findById(idSubject));
        verify(subjectRepositoryJpa, times(1)).findById(idSubject);
    }

    @Test
    void findAll_shouldReturnListOfSubjects() {
        // Given
        List<SubjectJpa> subjectJpaList = new ArrayList<>();
        subjectJpaList.add(new SubjectJpa());
        when(subjectRepositoryJpa.findAll()).thenReturn(subjectJpaList);

        // When
        List<Subject> subjects = retrieveSubjectRepository.findAll();

        // Then
        assertNotNull(subjects);
        assertEquals(1, subjects.size());
        verify(subjectRepositoryJpa, times(1)).findAll();
    }

    @Test
    void findByIdStudent_shouldReturnListOfSubjects() {
        // Given
        Long idStudent = 1L;
        List<SubjectJpa> subjectJpaList = new ArrayList<>();
        SubjectJpa subjectJpa = new SubjectJpa();
        subjectJpaList.add(subjectJpa);
        when(studentRepositoryJpa.findById(idStudent)).thenReturn(Optional.of(new StudentJpa() {
            @Override
            public List<SubjectJpa> getSubjects() {
                return subjectJpaList;
            }
        }));

        // When
        List<Subject> subjects = retrieveSubjectRepository.findByIdStudent(idStudent);

        // Then
        assertNotNull(subjects);
        assertEquals(1, subjects.size());
        verify(studentRepositoryJpa, times(1)).findById(idStudent);
    }
}
