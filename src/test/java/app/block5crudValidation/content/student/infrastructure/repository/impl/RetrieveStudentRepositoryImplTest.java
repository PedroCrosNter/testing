package app.block5crudValidation.content.student.infrastructure.repository.impl;

import app.block5crudValidation.content.person.application.mapper.PersonEntityMapper;
import app.block5crudValidation.content.person.infrastructure.repository.jpa.entity.PersonJpa;
import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import app.block5crudValidation.content.teacher.application.mapper.TeacherEntityMapper;
import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import app.block5crudValidation.shared.enums.Branch;
import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RetrieveStudentRepositoryImplTest {

    @Mock
    private StudentRepositoryJpa studentRepositoryJpa;

    @InjectMocks
    private RetrieveStudentRepositoryImpl retrieveStudentRepositoryImpl;

    private StudentJpa studentJpa;
    private Student student;

    @BeforeEach
    void setUp() {
        studentJpa = new StudentJpa();
        studentJpa.setIdStudent(1L);
        studentJpa.setNumHoursWeek(20);
        studentJpa.setBranch(Branch.FULLSTACK);

        PersonJpa personJpa = new PersonJpa();
        personJpa.setIdPerson(1L);
        studentJpa.setPersonJpa(personJpa);

        TeacherJpa teacherJpa = new TeacherJpa();
        teacherJpa.setIdTeacher(1L);
        studentJpa.setTeacherJpa(teacherJpa);

        student = new Student();
        student.setIdStudent(1L);
        student.setNumHoursWeek(20);
        student.setBranch(Branch.FRONT);
        student.setPerson(
                PersonEntityMapper.INSTANCE.toEntity(personJpa)
        );
        student.setTeacher(
                TeacherEntityMapper.INSTANCE.toEntity(teacherJpa)
        );
    }

    @Test
    void findById_success() {
        // Given
        when(studentRepositoryJpa.existsById(1L)).thenReturn(true);
        when(studentRepositoryJpa.findById(1L)).thenReturn(Optional.of(studentJpa));

        // When
        Student result = retrieveStudentRepositoryImpl.findById(1L);

        // Then
        assertNotNull(result);
        assertEquals(1L, result.getIdStudent());
        assertEquals(20, result.getNumHoursWeek());
//        assertEquals("Science", result.getBranch());
        assertNotNull(result.getPerson());
        assertNotNull(result.getTeacher());
    }

    @Test
    void findById_notFound() {
        // Given
        when(studentRepositoryJpa.existsById(1L)).thenReturn(false);

        // When & Then
        assertThrows(EntityNotFoundException.class, () -> retrieveStudentRepositoryImpl.findById(1L));
    }

    @Test
    void findAll_success() {
        // Given
        StudentJpa studentJpa2 = new StudentJpa();
        studentJpa2.setIdStudent(2L);
        studentJpa2.setNumHoursWeek(15);
        studentJpa2.setBranch(Branch.BACK);

        when(studentRepositoryJpa.findAll()).thenReturn(Arrays.asList(studentJpa, studentJpa2));

        // When
        List<Student> result = retrieveStudentRepositoryImpl.findAll();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());

        Student resultStudent1 = result.get(0);
        assertEquals(1L, resultStudent1.getIdStudent());
        assertEquals(20, resultStudent1.getNumHoursWeek());
//        assertEquals("Science", resultStudent1.getBranch());

        Student resultStudent2 = result.get(1);
        assertEquals(2L, resultStudent2.getIdStudent());
        assertEquals(15, resultStudent2.getNumHoursWeek());
//        assertEquals("Math", resultStudent2.getBranch());
    }
}
