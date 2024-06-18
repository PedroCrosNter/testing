package app.block5crudValidation.content.teacher.application.impl;

import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.content.teacher.domain.repository.RetrieveTeacherRepository;
import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class RetrieveTeacherUseCaseImplTest {

    @Mock
    private RetrieveTeacherRepository retrieveTeacherRepository;

    @InjectMocks
    private RetrieveTeacherUseCaseImpl retrieveTeacherUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findExistingTeacher() {
        // Arrange
        Long id = 1L;
        Teacher expectedTeacher = new Teacher(id, null, "Comments", null, null);
        when(retrieveTeacherRepository.find(id)).thenReturn(expectedTeacher);

        // Act
        Teacher foundTeacher = retrieveTeacherUseCase.find(id);

        // Assert
        assertNotNull(foundTeacher);
        assertEquals(expectedTeacher, foundTeacher);
        verify(retrieveTeacherRepository, times(1)).find(id);
    }

    @Test
    void findNonExistingTeacher() {
        // Arrange
        Long id = 2L;
        when(retrieveTeacherRepository.find(anyLong())).thenThrow(new EntityNotFoundException(Teacher.class, id));

        // Act and Assert
        assertThrows(EntityNotFoundException.class, () -> retrieveTeacherUseCase.find(id));
        verify(retrieveTeacherRepository, times(1)).find(id);
    }

    @Test
    void findAllTeachers() {
        // Arrange
        List<Teacher> expectedTeachers = Arrays.asList(
                new Teacher(1L, null, "Comments1", null, null),
                new Teacher(2L, null, "Comments2", null, null)
        );
        when(retrieveTeacherRepository.findAll()).thenReturn(expectedTeachers);

        // Act
        List<Teacher> foundTeachers = retrieveTeacherUseCase.findAll();

        // Assert
        assertNotNull(foundTeachers);
        assertEquals(expectedTeachers.size(), foundTeachers.size());
        assertTrue(foundTeachers.containsAll(expectedTeachers));
        verify(retrieveTeacherRepository, times(1)).findAll();
    }

    @Test
    void findAllTeachersEmptyList() {
        // Arrange
        when(retrieveTeacherRepository.findAll()).thenReturn(Collections.emptyList());

        // Act
        List<Teacher> foundTeachers = retrieveTeacherUseCase.findAll();

        // Assert
        assertNotNull(foundTeachers);
        assertTrue(foundTeachers.isEmpty());
        verify(retrieveTeacherRepository, times(1)).findAll();
    }
}
