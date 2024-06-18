package app.block5crudValidation.content.subject.infrastructure.controller;

import app.block5crudValidation.content.subject.application.RetrieveSubjectUseCase;
import app.block5crudValidation.content.subject.domain.entity.Subject;
import app.block5crudValidation.content.subject.infrastructure.controller.dto.output.SubjectOutputDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class RetrieveSubjectControllerTest {

    @Mock
    private RetrieveSubjectUseCase retrieveSubjectUseCase;

    @InjectMocks
    private RetrieveSubjectController retrieveSubjectController;

    public RetrieveSubjectControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void find() {
        // Given
        Long idSubject = 1L;
        Subject subject = new Subject();
        subject.setIdSubject(idSubject);
        subject.setName("Math");

        when(retrieveSubjectUseCase.findById(idSubject)).thenReturn(subject);

        // When
        ResponseEntity<?> responseEntity = retrieveSubjectController.find(idSubject, "simple");

        // Then
        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
//        assertEquals(SubjectDtoMapper.INSTANCE.toOutputDto(subject), responseEntity.getBody());

        // Verify
        verify(retrieveSubjectUseCase, times(1)).findById(idSubject);
    }

    @Test
    void findFull() {
        // Given
        Long idSubject = 1L;
        Subject subject = new Subject();
        subject.setIdSubject(idSubject);
        subject.setName("Math");

        when(retrieveSubjectUseCase.findById(idSubject)).thenReturn(subject);

        // When
        ResponseEntity<?> responseEntity = retrieveSubjectController.find(idSubject, "full");

        // Then
        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
//        assertEquals(SubjectDtoMapper.INSTANCE.toOutputDtoDetails(subject), responseEntity.getBody());

        // Verify
        verify(retrieveSubjectUseCase, times(1)).findById(idSubject);
    }

    @Test
    void findAll() {
        // Given
        List<Subject> subjects = new ArrayList<>();
        Subject subject1 = new Subject();
        subject1.setIdSubject(1L);
        subject1.setName("Math");
        subjects.add(subject1);

        when(retrieveSubjectUseCase.findAll()).thenReturn(subjects);

        // When
        ResponseEntity<List<SubjectOutputDto>> responseEntity = retrieveSubjectController.findAll();

        // Then
        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
//        assertEquals(SubjectDtoMapper.INSTANCE.toOutputDtoList(subjects), responseEntity.getBody());

        // Verify
        verify(retrieveSubjectUseCase, times(1)).findAll();
    }
}
