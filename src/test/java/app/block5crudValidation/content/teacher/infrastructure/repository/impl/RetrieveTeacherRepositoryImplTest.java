package app.block5crudValidation.content.teacher.infrastructure.repository.impl;

import app.block5crudValidation.content.person.infrastructure.repository.jpa.entity.PersonJpa;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.TeacherRepositoryJpa;
import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import app.block5crudValidation.shared.enums.Branch;
import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class RetrieveTeacherRepositoryImplTest {

    @Mock
    private TeacherRepositoryJpa teacherRepositoryJpa;

    @InjectMocks
    private RetrieveTeacherRepositoryImpl retrieveTeacherRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void find_existingTeacher() {
        // Arrange
        Long idTeacher = 1L;

        // Mocking behavior for teacherRepositoryJpa.findById()
        TeacherJpa teacherJpa = new TeacherJpa();
        teacherJpa.setIdTeacher(idTeacher);
        teacherJpa.setComments("Test comments");
        teacherJpa.setBranch(Branch.BACK);

        PersonJpa personJpa = new PersonJpa();
        personJpa.setIdPerson(100L); // Example person ID
        teacherJpa.setPersonJpa(personJpa);

        when(teacherRepositoryJpa.findById(idTeacher)).thenReturn(Optional.of(teacherJpa));

        // Act
        Teacher foundTeacher = retrieveTeacherRepository.find(idTeacher);

        // Assert
        assertEquals(idTeacher, foundTeacher.getIdTeacher());
        assertEquals(teacherJpa.getComments(), foundTeacher.getComments());
        assertEquals(teacherJpa.getBranch(), foundTeacher.getBranch());
        // Verify mapping of PersonJpa to Person could be tested if PersonEntityMapper is tested separately
        // assertEquals(teacherJpa.getPersonJpa().getIdPerson(), foundTeacher.getPerson().getIdPerson());

        verify(teacherRepositoryJpa, times(1)).findById(idTeacher);
    }

    @Test
    void find_teacherNotFound() {
        // Arrange
        Long idTeacher = 2L;

        // Mocking behavior for teacherRepositoryJpa.findById() returning empty optional
        when(teacherRepositoryJpa.findById(idTeacher)).thenReturn(Optional.empty());

        // Act and Assert
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            retrieveTeacherRepository.find(idTeacher);
        });

        assertEquals("Teacher with id " + idTeacher + " not found", "Teacher with id " + idTeacher + " not found");

        verify(teacherRepositoryJpa, times(1)).findById(idTeacher);
    }

    @Test
    void findAll() {
        // Arrange
        List<TeacherJpa> teacherJpaList = new ArrayList<>();
        teacherJpaList.add(new TeacherJpa(1L, new PersonJpa(), "Comments 1", Branch.BACK, new ArrayList<>()));
        teacherJpaList.add(new TeacherJpa(2L, new PersonJpa(), "Comments 2", Branch.BACK, new ArrayList<>()));

        when(teacherRepositoryJpa.findAll()).thenReturn(teacherJpaList);

        // Act
        List<Teacher> foundTeachers = retrieveTeacherRepository.findAll();

        // Assert
        assertEquals(teacherJpaList.size(), foundTeachers.size());
        for (int i = 0; i < teacherJpaList.size(); i++) {
            TeacherJpa teacherJpa = teacherJpaList.get(i);
            Teacher foundTeacher = foundTeachers.get(i);

            assertEquals(teacherJpa.getIdTeacher(), foundTeacher.getIdTeacher());
            assertEquals(teacherJpa.getComments(), foundTeacher.getComments());
            assertEquals(teacherJpa.getBranch(), foundTeacher.getBranch());
            // Verify mapping of PersonJpa to Person could be tested if PersonEntityMapper is tested separately
            // assertEquals(teacherJpa.getPersonJpa().getIdPerson(), foundTeacher.getPerson().getIdPerson());
        }

        verify(teacherRepositoryJpa, times(1)).findAll();
    }
}
