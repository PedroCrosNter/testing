package app.block5crudValidation.content.teacher.infrastructure.controller;

import app.block5crudValidation.content.teacher.application.UpdateTeacherUseCase;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.content.teacher.infrastructure.controller.dto.input.TeacherUpdateInputDto;
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
import static org.mockito.Mockito.*;

class UpdateTeacherControllerTest {

    @Mock
    private UpdateTeacherUseCase updateTeacherUseCase;

    @InjectMocks
    private UpdateTeacherController updateTeacherController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void update() {
        // Arrange
        Long idTeacher = 1L;
        Long idPerson = 101L;
        String comments = "Updated comments";
        Branch branch = Branch.BACK;

        TeacherUpdateInputDto inputDto = new TeacherUpdateInputDto(idTeacher, idPerson, comments, branch);

        Teacher teacherToUpdate = new Teacher(idTeacher, null, comments, branch, null);

        when(updateTeacherUseCase.update(any(Teacher.class))).thenReturn(idTeacher);

        // Act
        ResponseEntity<Long> responseEntity = updateTeacherController.update(inputDto);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(idTeacher, responseEntity.getBody());

        // Verify interactions
        verify(updateTeacherUseCase, times(1)).update(any(Teacher.class));
    }
}
