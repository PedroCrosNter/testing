package app.block5crudValidation.content.teacher.infrastructure.controller;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.teacher.application.RetrieveTeacherUseCase;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.content.teacher.infrastructure.controller.dto.output.TeacherDetailsOutputDto;
import app.block5crudValidation.content.teacher.infrastructure.controller.dto.output.TeacherOutputDto;
import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RetrieveTeacherControllerTest {

    @Mock
    private RetrieveTeacherUseCase retrieveTeacherUseCase;

    @InjectMocks
    private RetrieveTeacherController retrieveTeacherController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById_simpleOuterType() {
        // Arrange
        Long idTeacher = 1L;
        String outerType = "simple";
        Teacher teacher = createTeacherMock(idTeacher);

        when(retrieveTeacherUseCase.find(idTeacher)).thenReturn(teacher);

        // Act
        ResponseEntity<?> response = retrieveTeacherController.findById(idTeacher, outerType);

        // Assert
        assertEquals(200, response.getStatusCodeValue());

        Object body = response.getBody();
        assertNotNull(body);
        assertTrue(body instanceof TeacherOutputDto);

        TeacherOutputDto outputDto = (TeacherOutputDto) body;
        assertEquals(idTeacher, outputDto.getIdTeacher());
        assertEquals(teacher.getComments(), outputDto.getComments());
        assertEquals(teacher.getBranch(), outputDto.getBranch());

        verify(retrieveTeacherUseCase, times(1)).find(idTeacher);
    }

    @Test
    void findById_fullOuterType() {
        // Arrange
        Long idTeacher = 1L;
        String outerType = "full";
        Teacher teacher = createTeacherMock(idTeacher);

        when(retrieveTeacherUseCase.find(idTeacher)).thenReturn(teacher);

        // Act
        ResponseEntity<?> response = retrieveTeacherController.findById(idTeacher, outerType);

        // Assert
        assertEquals(200, response.getStatusCodeValue());

        Object body = response.getBody();
        assertNotNull(body);
        assertTrue(body instanceof TeacherDetailsOutputDto);

        TeacherDetailsOutputDto outputDto = (TeacherDetailsOutputDto) body;
        assertEquals(idTeacher, outputDto.getIdTeacher());
        assertEquals(teacher.getComments(), outputDto.getComments());
        assertEquals(teacher.getBranch(), outputDto.getBranch());

        // Since we are mocking a simple scenario, we won't validate 'person' and 'students' here
        verify(retrieveTeacherUseCase, times(1)).find(idTeacher);
    }

    @Test
    void findAll() {
        // Arrange
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(createTeacherMock(1L));
        teachers.add(createTeacherMock(2L));

        when(retrieveTeacherUseCase.findAll()).thenReturn(teachers);

        // Act
        ResponseEntity<List<TeacherOutputDto>> response = retrieveTeacherController.findAll();

        // Assert
        assertEquals(200, response.getStatusCodeValue());

        List<TeacherOutputDto> body = response.getBody();
        assertNotNull(body);
        assertEquals(teachers.size(), body.size());

        for (int i = 0; i < teachers.size(); i++) {
            Teacher teacher = teachers.get(i);
            TeacherOutputDto outputDto = body.get(i);

            assertEquals(teacher.getIdTeacher(), outputDto.getIdTeacher());
            assertEquals(teacher.getComments(), outputDto.getComments());
            assertEquals(teacher.getBranch(), outputDto.getBranch());
        }

        verify(retrieveTeacherUseCase, times(1)).findAll();
    }

    private Teacher createTeacherMock(Long idTeacher) {
        return new Teacher(idTeacher, new Person(), "Test comments", Branch.BACK, new ArrayList<>());
    }
}
