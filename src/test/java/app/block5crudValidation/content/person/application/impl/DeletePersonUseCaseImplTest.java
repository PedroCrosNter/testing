package app.block5crudValidation.content.person.application.impl;

import app.block5crudValidation.content.person.domain.repository.DeletePersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class DeletePersonUseCaseImplTest {

    @Mock
    private DeletePersonRepository deletePersonRepository;

    private DeletePersonUseCaseImpl deletePersonUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deletePersonUseCase = new DeletePersonUseCaseImpl(deletePersonRepository);
    }

    @Test
    void delete_LongId() {
        // Given
        Long idPerson = 1L;

        // When
        deletePersonUseCase.delete(idPerson);

        // Then
        verify(deletePersonRepository).delete(idPerson);
    }

    @Test
    void delete_StringId() {
        // Given
        String idPerson = "1";

        // When
        deletePersonUseCase.delete(idPerson);

        // Then
        verify(deletePersonRepository).delete(1L);
    }
}
