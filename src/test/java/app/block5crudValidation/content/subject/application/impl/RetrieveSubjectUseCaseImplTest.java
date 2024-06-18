package app.block5crudValidation.content.subject.application.impl;

import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import app.block5crudValidation.content.subject.domain.entity.Subject;
import app.block5crudValidation.content.subject.domain.repository.RetrieveSubjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RetrieveSubjectUseCaseImplTest {

    @Mock
    private RetrieveSubjectRepository retrieveSubjectRepository;

    @InjectMocks
    private RetrieveSubjectUseCaseImpl retrieveSubjectUseCaseImpl;

    private Subject subject;

    @BeforeEach
    void setUp() {
        subject = new Subject();
        subject.setIdSubject(1L);
        subject.setName("Math");
    }

    @Test
    void findById_success() {
        // Given
        when(retrieveSubjectRepository.findById(1L)).thenReturn(subject);

        // When
        Subject result = retrieveSubjectUseCaseImpl.findById(1L);

        // Then
        assertNotNull(result);
        assertEquals(1L, result.getIdSubject());
        assertEquals("Math", result.getName());
    }

    @Test
    void findById_notFound() {
        // Given
        when(retrieveSubjectRepository.findById(1L)).thenThrow(new EntityNotFoundException(Subject.class, 1L));

        // When & Then
        assertThrows(EntityNotFoundException.class, () -> retrieveSubjectUseCaseImpl.findById(1L));
    }

    @Test
    void findAll_success() {
        // Given
        Subject subject2 = new Subject();
        subject2.setIdSubject(2L);
        subject2.setName("Science");

        when(retrieveSubjectRepository.findAll()).thenReturn(Arrays.asList(subject, subject2));

        // When
        List<Subject> result = retrieveSubjectUseCaseImpl.findAll();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());

        Subject resultSubject1 = result.get(0);
        assertEquals(1L, resultSubject1.getIdSubject());
        assertEquals("Math", resultSubject1.getName());

        Subject resultSubject2 = result.get(1);
        assertEquals(2L, resultSubject2.getIdSubject());
        assertEquals("Science", resultSubject2.getName());
    }

    @Test
    void findByIdStudent_success() {
        // Given
        Subject subject2 = new Subject();
        subject2.setIdSubject(2L);
        subject2.setName("Science");

        when(retrieveSubjectRepository.findByIdStudent(1L)).thenReturn(Arrays.asList(subject, subject2));

        // When
        List<Subject> result = retrieveSubjectUseCaseImpl.findByIdStudent(1L);

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());

        Subject resultSubject1 = result.get(0);
        assertEquals(1L, resultSubject1.getIdSubject());
        assertEquals("Math", resultSubject1.getName());

        Subject resultSubject2 = result.get(1);
        assertEquals(2L, resultSubject2.getIdSubject());
        assertEquals("Science", resultSubject2.getName());
    }
}
