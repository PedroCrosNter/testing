package app.block5crudValidation.content.student.infrastructure.controller;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.student.application.AddSubjectsToStudentUseCase;
import app.block5crudValidation.content.student.application.CreateStudentUseCase;
import app.block5crudValidation.content.student.application.RetrieveStudentUseCase;
import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.student.infrastructure.controller.dto.input.StudentCreateInputDto;
import app.block5crudValidation.content.student.infrastructure.controller.dto.input.StudentManageSubjectsInputDto;
import app.block5crudValidation.content.student.infrastructure.controller.dto.output.StudentDetailsOutputDto;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CreateStudentControllerTest {

    @Mock
    private CreateStudentUseCase createStudentUseCase;

    @Mock
    private RetrieveStudentUseCase retrieveStudentUseCase;

    @Mock
    private AddSubjectsToStudentUseCase addSubjectsToStudentUseCase;

    @InjectMocks
    private CreateStudentController createStudentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateStudent() {
        // Arrange
        StudentCreateInputDto request = new StudentCreateInputDto();
        request.setIdPerson(3L);
        request.setNumHoursWeek(20);
        request.setIdTeacher(2001L);
        request.setBranch(Branch.FRONT); // Set branch according to your needs

        // Mocking the response from createStudentUseCase
        Long createdStudentId = 1L;
        when(createStudentUseCase.save(any(StudentCreateInputDto.class))).thenReturn(createdStudentId);

        // Act
        ResponseEntity<Long> responseEntity = createStudentController.save(request);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(createdStudentId, responseEntity.getBody());

        // Verify that createStudentUseCase.save() was called with the correct argument
        ArgumentCaptor<StudentCreateInputDto> studentCaptor = ArgumentCaptor.forClass(StudentCreateInputDto.class);
        verify(createStudentUseCase, times(1)).save(studentCaptor.capture());
        StudentCreateInputDto capturedStudentDto = studentCaptor.getValue();
        assertEquals(request.getIdPerson(), capturedStudentDto.getIdPerson());
        assertEquals(request.getNumHoursWeek(), capturedStudentDto.getNumHoursWeek());
        assertEquals(request.getIdTeacher(), capturedStudentDto.getIdTeacher());
        assertEquals(request.getBranch(), capturedStudentDto.getBranch());
        // Verify other fields as needed
    }

    @Test
    void testAddSubjectsToStudent() {
        // Arrange
        StudentManageSubjectsInputDto request = new StudentManageSubjectsInputDto();
        request.setIdStudent(1L);
        request.setIdsSubjects(Arrays.asList(101L, 102L, 103L)); // Example subjects IDs

        // Mocking the response from addSubjectsToStudentUseCase
        Student studentWithSubjects = new Student();
        studentWithSubjects.setIdStudent(request.getIdStudent());
        studentWithSubjects.setPerson(new Person()); // Set person object as needed
        studentWithSubjects.setNumHoursWeek(20); // Set other fields as needed
        studentWithSubjects.setTeacher(new Teacher()); // Set teacher object as needed
        studentWithSubjects.setBranch(Branch.FRONT); // Set branch according to your needs
        // Mocking the response from addSubjectsToStudentUseCase
        when(addSubjectsToStudentUseCase.addSubjects(eq(request.getIdStudent()), anyList())).thenReturn(studentWithSubjects);

        // Act
        ResponseEntity<StudentDetailsOutputDto> responseEntity = createStudentController.addSubjectsByIdStudent(request);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        StudentDetailsOutputDto responseBody = responseEntity.getBody();
        assertEquals(request.getIdStudent(), responseBody.getIdStudent());
        // Assert other fields as needed

        // Verify that addSubjectsToStudentUseCase.addSubjects() was called with the correct arguments
        verify(addSubjectsToStudentUseCase, times(1)).addSubjects(eq(request.getIdStudent()), anyList());
    }
}
