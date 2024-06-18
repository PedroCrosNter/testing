package app.block5crudValidation.content.student.infrastructure.repository.impl;

import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateStudentRepositoryImplTest {

    @Mock
    private StudentRepositoryJpa studentRepositoryJpa;

    private CreateStudentRepositoryImpl createStudentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createStudentRepository = new CreateStudentRepositoryImpl(studentRepositoryJpa);
    }

    @Test
    void save() {
        // Given
        Student student = new Student(); // Create a Student object as per your test needs

        // Mock behavior
        StudentJpa studentJpa = new StudentJpa(); // Create a StudentJpa object if needed
        studentJpa.setIdStudent(1L); // Set ID as needed

        when(studentRepositoryJpa.save(any(StudentJpa.class))).thenReturn(studentJpa);

        // When
        Long savedStudentId = createStudentRepository.save(student);

        // Then
        assertNotNull(savedStudentId);
        assertEquals(1L, savedStudentId); // Assuming ID is set to 1 in mocked StudentJpa
        verify(studentRepositoryJpa, times(1)).save(any(StudentJpa.class));
    }
}
