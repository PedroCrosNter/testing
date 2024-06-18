package app.block5crudValidation.content.teacher.application.impl;

import app.block5crudValidation.content.teacher.application.RetrieveTeacherUseCase;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.content.teacher.domain.repository.UpdateTeacherRepository;
import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UpdateTeacherUseCaseImplTest {

    @Mock
    private UpdateTeacherRepository updateTeacherRepository;

    @Mock
    private RetrieveTeacherUseCase retrieveTeacherUseCase;

    @InjectMocks
    private UpdateTeacherUseCaseImpl updateTeacherUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUpdateExistingTeacher() {
        // Arrange
        Teacher teacherToUpdate = new Teacher();
        teacherToUpdate.setIdTeacher(1L);

        Teacher existingTeacher = new Teacher();
        existingTeacher.setIdTeacher(1L);

        // Mock behavior of retrieveTeacherUseCase.find()
        when(retrieveTeacherUseCase.find(teacherToUpdate.getIdTeacher())).thenReturn(existingTeacher);

        // Mock behavior of updateTeacherRepository.update()
        when(updateTeacherRepository.update(any(Teacher.class))).thenReturn(existingTeacher);

        // Act
        Long updatedTeacherId = updateTeacherUseCase.update(teacherToUpdate);

        // Assert
        assertEquals(existingTeacher.getIdTeacher(), updatedTeacherId);

        // Verify that retrieveTeacherUseCase.find() and updateTeacherRepository.update() were called
        verify(retrieveTeacherUseCase, times(1)).find(teacherToUpdate.getIdTeacher());
        verify(updateTeacherRepository, times(1)).update(teacherToUpdate);
    }

    @Test
    void testUpdateNonExistingTeacher() {
        // Arrange
        Teacher teacherToUpdate = new Teacher();
        teacherToUpdate.setIdTeacher(1L);

        // Mock behavior of retrieveTeacherUseCase.find() to throw EntityNotFoundException
        when(retrieveTeacherUseCase.find(teacherToUpdate.getIdTeacher())).thenThrow(EntityNotFoundException.class);

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> {
            updateTeacherUseCase.update(teacherToUpdate);
        });

        // Verify that retrieveTeacherUseCase.find() was called
        verify(retrieveTeacherUseCase, times(1)).find(teacherToUpdate.getIdTeacher());
        // Ensure updateTeacherRepository.update() was not called
        verify(updateTeacherRepository, never()).update(any(Teacher.class));
    }
}
