package app.block5crudValidation.content.teacher.infrastructure.controller;

import app.block5crudValidation.content.teacher.application.DeleteTeacherUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DeleteTeacherControllerTest {

    @Mock
    private DeleteTeacherUseCase deleteTeacherUseCase;

    @InjectMocks
    private DeleteTeacherController deleteTeacherController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void delete() {
        // Arrange
        Long idTeacher = 1L;

        // Act
        ResponseEntity<?> response = deleteTeacherController.save(idTeacher);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verify
        verify(deleteTeacherUseCase, times(1)).delete(idTeacher);
    }
}
