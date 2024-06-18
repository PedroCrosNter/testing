package app.block5crudValidation.content.student.infrastructure.controller;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.student.application.DeleteStudentUseCase;
import app.block5crudValidation.content.student.application.RemoveSubjectsToStudentUseCase;
import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.student.infrastructure.controller.dto.input.StudentManageSubjectsInputDto;
import app.block5crudValidation.content.student.infrastructure.controller.dto.output.StudentDetailsOutputDto;
import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeleteStudentControllerTest {

    @Mock
    private DeleteStudentUseCase deleteStudentUseCase;

    @Mock
    private RemoveSubjectsToStudentUseCase removeSubjectsToStudentUseCase;

    @InjectMocks
    private DeleteStudentController deleteStudentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void delete() {
        // Arrange
        Long idStudentToDelete = 1L;
        when(deleteStudentUseCase.delete(idStudentToDelete)).thenReturn(true);

        // Act
        ResponseEntity<Boolean> response = deleteStudentController.delete(idStudentToDelete);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertTrue(response.getBody());

        // Verify that deleteStudentUseCase.delete() was called once with correct parameter
        verify(deleteStudentUseCase, times(1)).delete(idStudentToDelete);
    }

    @Test
    void removeSubjectsByIdStudent() {
        // Arrange
        Long idStudent = 1L;
        StudentManageSubjectsInputDto inputDto = new StudentManageSubjectsInputDto(idStudent, Arrays.asList(101L, 102L));

        // Mockeo del caso de uso RemoveSubjectsToStudentUseCase
        Student student = new Student();
        student.setIdStudent(idStudent);
        student.setNumHoursWeek(20); // Ejemplo de datos para numHoursWeek
        student.setBranch(Branch.FRONT); // Ejemplo de datos para branch
        Person person = new Person();
        person.setIdPerson(1L);
        student.setPerson(person);

        when(removeSubjectsToStudentUseCase.removeSubjects(idStudent, inputDto.getIdsSubjects())).thenReturn(student);

        // Act
        ResponseEntity<StudentDetailsOutputDto> response = deleteStudentController.removeSubjectsByIdStudent(inputDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(idStudent, response.getBody().getIdStudent());
        assertEquals(student.getNumHoursWeek(), response.getBody().getNumHoursWeek());
        assertEquals(student.getBranch(), response.getBody().getBranch());
        // Verificar que el mock del caso de uso se llamó correctamente
        verify(removeSubjectsToStudentUseCase, times(1)).removeSubjects(idStudent, inputDto.getIdsSubjects());
    }
}
