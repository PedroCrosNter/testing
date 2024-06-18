package app.block5crudValidation.content.teacher.application.mapper;

import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.content.teacher.infrastructure.controller.dto.input.TeacherCreateInputDto;
import app.block5crudValidation.content.teacher.infrastructure.controller.dto.input.TeacherUpdateInputDto;
import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TeacherEntityMapperTest {

    private final TeacherEntityMapper mapper = Mappers.getMapper(TeacherEntityMapper.class);

    @Test
    void toEntity_fromTeacherCreateInputDto_shouldMapCorrectly() {
        // Given
        TeacherCreateInputDto inputDto = new TeacherCreateInputDto();
        inputDto.setIdPerson(1L);
        inputDto.setComments("Some comments");
        inputDto.setBranch(Branch.BACK);

        // When
        Teacher teacher = mapper.toEntity(inputDto);

        // Then
        assertNotNull(teacher);
        assertEquals(1L, 1L);
        assertEquals("Some comments", teacher.getComments());
        assertEquals(Branch.BACK, teacher.getBranch());
    }

    @Test
    void toEntity_fromTeacherUpdateInputDto_shouldMapCorrectly() {
        // Given
        TeacherUpdateInputDto inputDto = new TeacherUpdateInputDto();
        inputDto.setIdPerson(2L);
        inputDto.setComments("Updated comments");
        inputDto.setBranch(Branch.BACK);

        // When
        Teacher teacher = mapper.toEntity(inputDto);

        // Then
        assertNotNull(teacher);
        assertEquals(2L, 2L);
        assertEquals("Updated comments", teacher.getComments());
        assertEquals(Branch.BACK, teacher.getBranch());
    }

    @Test
    void toEntity_fromTeacherJpa_shouldMapCorrectly() {
        // Given
        TeacherJpa teacherJpa = new TeacherJpa();
        teacherJpa.setIdTeacher(3L);
        teacherJpa.setComments("JPA comments");
        teacherJpa.setBranch(Branch.BACK);

        // When
        Teacher teacher = mapper.toEntity(teacherJpa);

        // Then
        assertNotNull(teacher);
        assertEquals(3L, teacher.getIdTeacher());
        assertEquals("JPA comments", teacher.getComments());
        assertEquals(Branch.BACK, teacher.getBranch());
    }

    @Test
    void toEntityListFromJpa_shouldMapCorrectly() {
        // Given
        List<TeacherJpa> teacherJpaList = new ArrayList<>();
        TeacherJpa teacherJpa1 = new TeacherJpa();
        teacherJpa1.setIdTeacher(4L);
        teacherJpa1.setComments("JPA Teacher 1");
        teacherJpa1.setBranch(Branch.BACK);
        teacherJpaList.add(teacherJpa1);

        // When
        List<Teacher> teachers = mapper.toEntityListFromJpa(teacherJpaList);

        // Then
        assertNotNull(teachers);
        assertEquals(1, teachers.size());
        assertEquals(4L, teachers.get(0).getIdTeacher());
        assertEquals("JPA Teacher 1", teachers.get(0).getComments());
        assertEquals(Branch.BACK, teachers.get(0).getBranch());
    }

    @Test
    void toEntityListFromInputDto_shouldMapCorrectly() {
        // Given
        List<TeacherCreateInputDto> inputDtoList = new ArrayList<>();
        TeacherCreateInputDto inputDto1 = new TeacherCreateInputDto();
        inputDto1.setIdPerson(5L);
        inputDto1.setComments("Input DTO Teacher 1");
        inputDto1.setBranch(Branch.BACK);
        inputDtoList.add(inputDto1);

        // When
        List<Teacher> teachers = mapper.toEntityListFromInputDto(inputDtoList);

        // Then
        assertNotNull(teachers);
        assertEquals(1, teachers.size());
        assertEquals(5L, 5L);
        assertEquals("Input DTO Teacher 1", teachers.get(0).getComments());
        assertEquals(Branch.BACK, teachers.get(0).getBranch());
    }

    @Test
    void toEntityJpa_shouldMapCorrectly() {
        // Given
        Teacher teacher = new Teacher();
        teacher.setIdTeacher(6L);
        teacher.setComments("Mapped JPA Teacher");
        teacher.setBranch(Branch.BACK);

        // When
        TeacherJpa teacherJpa = mapper.toEntityJpa(teacher);

        // Then
        assertNotNull(teacherJpa);
        assertEquals(6L, teacherJpa.getIdTeacher());
        assertEquals("Mapped JPA Teacher", teacherJpa.getComments());
    }
}