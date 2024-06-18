package app.block5crudValidation.content.teacher.application.impl;

import app.block5crudValidation.content.teacher.domain.repository.DeleteTeacherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class DeleteTeacherUseCaseImplTest {

    @Mock
    private DeleteTeacherRepository deleteTeacherRepository;

    @InjectMocks
    private DeleteTeacherUseCaseImpl deleteTeacherUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deleteExistingTeacher() {
        // Arrange
        Long id = 1L;

        // Act
        deleteTeacherUseCase.delete(id);

        // Assert
        verify(deleteTeacherRepository, times(1)).delete(id);
    }

    @Test
    void deleteNonExistingTeacher() {
        // Arrange
        Long id = 2L;
        // Assuming DeleteTeacherRepository throws no exception when deleting a non-existing teacher

        // Act
        deleteTeacherUseCase.delete(id);

        // Assert
        verify(deleteTeacherRepository, times(1)).delete(id);
    }
}
