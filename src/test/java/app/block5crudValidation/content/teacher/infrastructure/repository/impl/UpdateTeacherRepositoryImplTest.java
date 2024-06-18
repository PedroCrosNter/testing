package app.block5crudValidation.content.teacher.infrastructure.repository.impl;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.TeacherRepositoryJpa;
import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UpdateTeacherRepositoryImplTest {

    @Mock
    private TeacherRepositoryJpa teacherRepositoryJpa;

    @InjectMocks
    private UpdateTeacherRepositoryImpl updateTeacherRepositoryImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void update() {
        // Arrange
        Long idTeacher = 1L;
        Person person = new Person(1L, "john.doe", "password", "John", "Doe", "john.doe@company.com",
                "john.doe@gmail.com", "New York", true, LocalDate.now(), "image.jpg", null);
        Branch branch = Branch.BACK;
        List<Student> students = new ArrayList<>();
        Teacher teacherToUpdate = new Teacher(idTeacher, person, "Updated comments", branch, students);

        TeacherJpa existingTeacherJpa = new TeacherJpa(idTeacher, null, "Initial comments", Branch.BACK, null);

        // Mock behavior
        when(teacherRepositoryJpa.findById(idTeacher)).thenReturn(Optional.of(existingTeacherJpa));
        when(teacherRepositoryJpa.save(any(TeacherJpa.class))).thenAnswer(invocation -> {
            TeacherJpa updatedTeacherJpa = invocation.getArgument(0);
            existingTeacherJpa.setComments(updatedTeacherJpa.getComments());
            existingTeacherJpa.setBranch(updatedTeacherJpa.getBranch());
            return existingTeacherJpa;
        });

        // Act
        Teacher updatedTeacher = updateTeacherRepositoryImpl.update(teacherToUpdate);

        // Assert
        assertEquals(teacherToUpdate.getIdTeacher(), updatedTeacher.getIdTeacher());
        assertEquals(teacherToUpdate.getComments(), updatedTeacher.getComments());
        assertEquals(teacherToUpdate.getBranch(), updatedTeacher.getBranch());

        // Verify interactions
        verify(teacherRepositoryJpa, times(1)).findById(idTeacher);
        verify(teacherRepositoryJpa, times(1)).save(any(TeacherJpa.class));
    }
}
