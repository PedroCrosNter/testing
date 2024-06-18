package app.block5crudValidation.content.subject.infrastructure.controller;

import app.block5crudValidation.content.subject.application.DeleteSubjectUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class DeleteSubjectControllerTest {

    @Mock
    private DeleteSubjectUseCase deleteSubjectUseCase;

    @InjectMocks
    private DeleteSubjectController deleteSubjectController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() {
        // ID de prueba
        Long idSubject = 1L;
        Boolean expectedDeletionResult = true;

        // Configuración del mock
        when(deleteSubjectUseCase.delete(anyLong())).thenReturn(expectedDeletionResult);

        // Llamada al método del controlador
        ResponseEntity<Boolean> responseEntity = deleteSubjectController.save(idSubject);

        // Verificaciones
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(expectedDeletionResult, responseEntity.getBody());
    }
}
