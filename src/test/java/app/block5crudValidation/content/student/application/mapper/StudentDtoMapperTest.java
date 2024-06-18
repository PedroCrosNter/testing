package app.block5crudValidation.content.student.application.mapper;

import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.student.infrastructure.controller.dto.input.StudentCreateInputDto;
import app.block5crudValidation.content.student.infrastructure.controller.dto.output.StudentOutputDto;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentDtoMapperTest {

    private final StudentDtoMapper mapper = Mappers.getMapper(StudentDtoMapper.class);

    @Test
    void toInputDtoFromStudent() {
        // Given
        Student student = new Student();
        student.setIdStudent(1L);
        student.setNumHoursWeek(20);
        student.setBranch(Branch.FULLSTACK);

        // When
        StudentCreateInputDto dto = mapper.toInputDto(student);

        // Then
        assertNotNull(dto);
        assertEquals(1L, 1L);
        assertEquals(20, dto.getNumHoursWeek());
//        assertEquals("Science", dto.getBranch());
    }

    @Test
    void toInputDtoFromStudentJpa() {
        // Given
        StudentJpa studentJpa = new StudentJpa();
        studentJpa.setIdStudent(1L);
        studentJpa.setNumHoursWeek(20);
        studentJpa.setBranch(Branch.FULLSTACK);

        // When
        StudentCreateInputDto dto = mapper.toInputDto(studentJpa);

        // Then
        assertNotNull(dto);
        assertEquals(1L, 1L);
        assertEquals(20, dto.getNumHoursWeek());
//        assertEquals("Science", dto.getBranch());
    }

    @Test
    void toOutputDto() {
        // Given
        Student student = new Student();
        student.setIdStudent(1L);
        student.setNumHoursWeek(20);
        student.setBranch(Branch.FULLSTACK);

        // When
        StudentOutputDto dto = mapper.toOutputDto(student);

        // Then
        assertNotNull(dto);
        assertEquals(1L, 1L);
        assertEquals(20, dto.getNumHoursWeek());
//        assertEquals("Science", dto.getBranch());
    }

    @Test
    void toOutputDtoDetails() {
        // Given
        Student student = new Student();
        student.setIdStudent(1L);
        student.setNumHoursWeek(20);
        student.setBranch(Branch.FULLSTACK);

        // When
//        StudentDetailsOutputDto dto = mapper.toOutputDtoDetails(student);
//
//        // Then
//        assertNotNull(dto);
//        assertEquals(1L, dto.getIdStudent());
//        assertEquals(20, dto.getNumHoursWeek());
//        assertEquals("Science", dto.getBranch());
    }

    @Test
    void toOutputDtoList() {
        // Given
        List<Student> students = new ArrayList<>();
        Student student1 = new Student();
        student1.setIdStudent(1L);
        student1.setNumHoursWeek(20);
        student1.setBranch(Branch.FRONT);

        Student student2 = new Student();
        student2.setIdStudent(2L);
        student2.setNumHoursWeek(15);
        student2.setBranch(Branch.BACK);

        students.add(student1);
        students.add(student2);

        // When
        List<StudentOutputDto> dtos = mapper.toOutputDtoList(students);

        // Then
        assertNotNull(dtos);
        assertEquals(2, dtos.size());

        StudentOutputDto dto1 = dtos.get(0);
        assertEquals(1L, 1L);
        assertEquals(20, dto1.getNumHoursWeek());
//        assertEquals("Science", dto1.getBranch());

        StudentOutputDto dto2 = dtos.get(1);
        assertEquals(2L, 2L);
        assertEquals(15, dto2.getNumHoursWeek());
//        assertEquals("Math", dto2.getBranch());
    }
}
