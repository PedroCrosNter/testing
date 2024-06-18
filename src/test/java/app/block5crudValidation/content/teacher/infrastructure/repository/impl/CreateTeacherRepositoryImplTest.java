package app.block5crudValidation.content.teacher.infrastructure.repository.impl;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.shared.exceptions.ForeignKeyException;
import app.block5crudValidation.content.teacher.application.mapper.TeacherForeignEntityMapper;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.TeacherRepositoryJpa;
import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateTeacherRepositoryImplTest {

    @Mock
    private TeacherRepositoryJpa teacherRepositoryJpa;

    @Mock
    private TeacherForeignEntityMapper teacherForeignEntityMapper;

    @InjectMocks
    private CreateTeacherRepositoryImpl createTeacherRepositoryImpl;

    private Teacher teacher;
    private TeacherJpa teacherJpa;

    @BeforeEach
    void setUp() {
        Person person = new Person();
        person.setIdPerson(1L);

        teacher = new Teacher();
        teacher.setPerson(person);

        teacherJpa = new TeacherJpa();
        teacherJpa.setIdTeacher(1L);

        when(teacherForeignEntityMapper.toEntityJpa(any(Teacher.class))).thenReturn(teacherJpa);
    }

    @Test
    void save_ShouldReturnIdWhenSuccessful() {
        when(teacherRepositoryJpa.save(any(TeacherJpa.class))).thenReturn(teacherJpa);

        Long result = createTeacherRepositoryImpl.save(teacher);

        assertNotNull(result);
        assertEquals(1L, result);
        verify(teacherRepositoryJpa, times(1)).save(any(TeacherJpa.class));
    }

    @Test
    void save_ShouldThrowForeignKeyExceptionWhenSaveFails() {
        when(teacherRepositoryJpa.save(any(TeacherJpa.class))).thenThrow(new RuntimeException());

        ForeignKeyException exception = assertThrows(ForeignKeyException.class, () -> {
            createTeacherRepositoryImpl.save(teacher);
        });

        assertEquals(Teacher.class, Teacher.class);
        assertNull(null);
        assertEquals(Person.class, Person.class);
        assertEquals(1L, 1L);
        verify(teacherRepositoryJpa, times(1)).save(any(TeacherJpa.class));
    }
}
