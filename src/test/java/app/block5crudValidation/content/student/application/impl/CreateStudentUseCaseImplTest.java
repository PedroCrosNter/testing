package app.block5crudValidation.content.student.application.impl;

import app.block5crudValidation.content.person.application.RetrievePersonUseCase;
import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.student.domain.repository.CreateStudentRepository;
import app.block5crudValidation.content.student.infrastructure.controller.dto.input.StudentCreateInputDto;
import app.block5crudValidation.content.teacher.application.RetrieveTeacherUseCase;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateStudentUseCaseImplTest {

    @Mock
    private CreateStudentRepository createStudentRepository;

    @Mock
    private RetrievePersonUseCase retrievePersonUseCase;

    @Mock
    private RetrieveTeacherUseCase retrieveTeacherUseCase;

    private CreateStudentUseCaseImpl createStudentUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createStudentUseCase = new CreateStudentUseCaseImpl(createStudentRepository, retrievePersonUseCase, retrieveTeacherUseCase);
    }

    @Test
    void save_WhenPersonAndTeacherExist_ReturnsStudentId() {
        // Given
        StudentCreateInputDto inputDto = new StudentCreateInputDto();
        inputDto.setIdPerson(1L);
        inputDto.setIdTeacher(1L);
        inputDto.setBranch(Branch.BACK);

        Person person = new Person();
        person.setIdPerson(1L);

        Teacher teacher = new Teacher();
        teacher.setIdTeacher(1L);

        // Mocking behavior of RetrievePersonUseCase to return the person
        when(retrievePersonUseCase.find(1L)).thenReturn(person);
        // Mocking behavior of RetrieveTeacherUseCase to return the teacher
        when(retrieveTeacherUseCase.find(1L)).thenReturn(teacher);
        // Mocking behavior of CreateStudentRepository
        when(createStudentRepository.save(any(Student.class))).thenReturn(1L);

        // When
        Long savedStudentId = createStudentUseCase.save(inputDto);

        // Then
        assertNotNull(savedStudentId);
        assertEquals(1L, savedStudentId);
        verify(retrievePersonUseCase).find(1L);
        verify(retrieveTeacherUseCase).find(1L);
        verify(createStudentRepository).save(any(Student.class));
    }

    @Test
    void save_WhenPersonAndTeacherDoNotExist_ReturnsNull() {
        // Given
        StudentCreateInputDto inputDto = new StudentCreateInputDto();
        inputDto.setIdPerson(1L);
        inputDto.setIdTeacher(1L);
        inputDto.setBranch(Branch.BACK);

        // Mocking behavior of RetrievePersonUseCase to return null
        when(retrievePersonUseCase.find(1L)).thenReturn(null);
        // Mocking behavior of RetrieveTeacherUseCase to return null
        when(retrieveTeacherUseCase.find(1L)).thenReturn(null);

        // When
        Long savedStudentId = createStudentUseCase.save(inputDto);

        // Then
        assertNotNull(savedStudentId);
        verify(retrievePersonUseCase).find(1L);
        verify(retrieveTeacherUseCase).find(1L);
    }
}
