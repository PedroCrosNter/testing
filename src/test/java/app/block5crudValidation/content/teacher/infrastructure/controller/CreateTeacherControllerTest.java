package app.block5crudValidation.content.teacher.infrastructure.controller;

import app.block5crudValidation.content.teacher.application.CreateTeacherUseCase;
import app.block5crudValidation.content.teacher.infrastructure.controller.dto.input.TeacherCreateInputDto;
import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CreateTeacherControllerTest {

    @Mock
    private CreateTeacherUseCase createTeacherUseCase;

    @InjectMocks
    private CreateTeacherController createTeacherController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() {
        // Arrange
        TeacherCreateInputDto inputDto = new TeacherCreateInputDto(1L, "Some comments", Branch.BACK);

        Long idTeacher = 1L;
        when(createTeacherUseCase.save(any(TeacherCreateInputDto.class))).thenReturn(idTeacher);

        // Act
        ResponseEntity<Long> response = createTeacherController.save(inputDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(idTeacher, response.getBody());
    }
}
