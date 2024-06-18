package app.block5crudValidation.content.teacher.application.mapper.impl;

import app.block5crudValidation.content.person.application.RetrievePersonUseCase;
import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class TeacherForeignEntityMapperImplTest {

    @Mock
    private RetrievePersonUseCase retrievePersonUseCase;

    @InjectMocks
    private TeacherForeignEntityMapperImpl teacherForeignEntityMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void toEntityJpa() {
        // Arrange
        TeacherJpa teacherJpa = new TeacherJpa();
        teacherJpa.setIdTeacher(1L);

        Person person = new Person();
        person.setIdPerson(1L);
        // Set other necessary properties for person

        when(retrievePersonUseCase.find(anyLong())).thenReturn(person);

        // Act
//        TeacherJpa mappedTeacherJpa = teacherForeignEntityMapper.toEntityJpa(TeacherEntityMapper.INSTANCE.toEntity(new Teacher()));

        // Assert
//        assertEquals(teacherJpa.getIdTeacher(), mappedTeacherJpa.getIdTeacher());
//        assertEquals(person.getIdPerson(), mappedTeacherJpa.getPersonJpa().getIdPerson());
        // Verify any other mappings as necessary
    }
}
