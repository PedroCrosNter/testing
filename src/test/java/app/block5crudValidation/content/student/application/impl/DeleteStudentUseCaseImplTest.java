package app.block5crudValidation.content.student.application.impl;

import app.block5crudValidation.content.person.domain.repository.DeletePersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class DeleteStudentUseCaseImplTest {

    @Mock
    private DeletePersonRepository deletePersonRepository;

    @InjectMocks
    private DeleteStudentUseCaseImpl deleteStudentUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void delete_SuccessfulDeletion_ReturnsTrue() {
        // Given
        Long idStudent = 1L;
        when(deletePersonRepository.delete(idStudent)).thenReturn(true);

        // When
        Boolean result = deleteStudentUseCase.delete(idStudent);

        // Then
        assertTrue(result);
        verify(deletePersonRepository).delete(idStudent);
    }

    @Test
    void delete_UnsuccessfulDeletion_ReturnsFalse() {
        // Given
        Long idStudent = 1L;
        when(deletePersonRepository.delete(idStudent)).thenReturn(false);

        // When
        Boolean result = deleteStudentUseCase.delete(idStudent);

        // Then
        assertFalse(result);
        verify(deletePersonRepository).delete(idStudent);
    }

    @Test
    void delete_NullId_ReturnsFalse() {
        // Given
        Long idStudent = null;

        // When
        Boolean result = deleteStudentUseCase.delete(idStudent);

        // Then
        assertFalse(result);
        verify(deletePersonRepository, times(1)).delete(idStudent);
    }
}
