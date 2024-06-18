package app.block5crudValidation.content.student.infrastructure.controller;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.student.application.CreateStudentUseCase;
import app.block5crudValidation.content.student.application.RetrieveStudentUseCase;
import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.student.infrastructure.controller.dto.input.StudentCreateInputDto;
import app.block5crudValidation.content.student.infrastructure.controller.dto.output.StudentDetailsOutputDto;
import app.block5crudValidation.content.subject.domain.entity.Subject;
import app.block5crudValidation.content.subject.infrastructure.controller.dto.output.SubjectOutputDto;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class RetrieveStudentControllerTest {

    @Mock
    private RetrieveStudentUseCase retrieveStudentUseCase;
    @Mock
    private CreateStudentUseCase createStudentUseCase;

    @InjectMocks
    private RetrieveStudentController retrieveStudentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById_shouldReturnSimpleDto() {
        // Given
        Long idStudent = 1L;
        StudentCreateInputDto studentInputDto = new StudentCreateInputDto();
        Student student = new Student();
        student.setIdStudent(idStudent);
        student.setNumHoursWeek(null);  // Ensure the student's numHoursWeek is set to null
        when(retrieveStudentUseCase.find(idStudent)).thenReturn(student);

        // Save the student using the createStudentUseCase mock
        createStudentUseCase.save(studentInputDto);

        // When
        ResponseEntity<Student> response = retrieveStudentController.findById(idStudent, "simple");

        // Then
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

//        Student responseBody = response.getBody();
//        assertNotNull(responseBody);
//        assertNull(responseBody.getNumHoursWeek());  // Ensure numHoursWeek is null in the response

        verify(retrieveStudentUseCase, times(1)).find(idStudent);
    }


    @Test
    void findById_shouldReturnFullDto() {
        // Given
        Long idStudent = 1L;
        Person person = new Person(); // Assuming a person object is correctly initialized here
        person.setIdPerson(1L);
        Teacher teacher = new Teacher(); // Assuming a teacher object is correctly initialized here
        teacher.setIdTeacher(1L);
        Branch branch = Branch.BACK; // Assuming Branch is an enum with value SCIENCE

        Student student = new Student();
        student.setIdStudent(idStudent);
        student.setPerson(person);
        student.setNumHoursWeek(20);
        student.setTeacher(teacher);
        student.setBranch(branch);

        when(retrieveStudentUseCase.find(idStudent)).thenReturn(student);

        // When
        ResponseEntity<StudentDetailsOutputDto> response = retrieveStudentController.findById(idStudent, "full");

        // Then
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

        StudentDetailsOutputDto responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals(idStudent, responseBody.getIdStudent());
        assertEquals(person, responseBody.getPerson());
        assertEquals(Integer.valueOf(20), responseBody.getNumHoursWeek());
        assertEquals(teacher, responseBody.getTeacher());
        assertEquals(branch, responseBody.getBranch());

        verify(retrieveStudentUseCase, times(1)).find(idStudent);
    }


//    @Test
//    void findAll_shouldReturnListOfStudents() {
//        // Given
//        List<Student> students = Collections.singletonList(new Student());
//        when(retrieveStudentUseCase.findAll()).thenReturn(students);
//
//        // When
//        ResponseEntity<List<StudentOutputDto>> response = retrieveStudentController.findAll();
//
//        // Then
//        assertNotNull(response);
//        assertEquals(200, response.getStatusCodeValue());
//        verify(retrieveStudentUseCase, times(1)).findAll();
//    }

    @Test
    void findSubjectsByIdStudent_shouldReturnListOfSubjects() {
        // Given
        Long idStudent = 1L;
        List<Subject> subjects = Collections.singletonList(new Subject());
        when(retrieveStudentUseCase.findSubjectsByIdStudent(idStudent)).thenReturn(subjects);

        // When
        ResponseEntity<List<SubjectOutputDto>> response = retrieveStudentController.findSubjectsByIdStudent(idStudent);

        // Then
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        verify(retrieveStudentUseCase, times(1)).findSubjectsByIdStudent(idStudent);
    }
}
