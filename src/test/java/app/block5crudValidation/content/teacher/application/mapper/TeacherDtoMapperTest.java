package app.block5crudValidation.content.teacher.application.mapper;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.content.teacher.infrastructure.controller.dto.output.TeacherDetailsOutputDto;
import app.block5crudValidation.content.teacher.infrastructure.controller.dto.output.TeacherOutputDto;
import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TeacherDtoMapperTest {

    @Test
    void toInputDto() {
        Teacher teacher = new Teacher();
        teacher.setIdTeacher(1L);
        Person person = new Person();
        person.setIdPerson(1L);
        person.setUsername("johndoe");
        teacher.setPerson(person);
        teacher.setComments("Great teacher");
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setIdStudent(1L);
        students.add(student);
        teacher.setStudents(students);

//        TeacherCreateInputDto inputDto = TeacherDtoMapper.INSTANCE.toInputDto(teacher);
//
//        assertNotNull(inputDto);
//        assertEquals("Great teacher", inputDto.getComments());
    }

    @Test
    void testToInputDto() {
        TeacherJpa teacherJpa = new TeacherJpa();
        teacherJpa.setIdTeacher(1L);
        Person person = new Person();
        person.setIdPerson(1L);
        person.setUsername("johndoe");
        teacherJpa.setComments("Great teacher");
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setIdStudent(1L);
        students.add(student);

//        TeacherCreateInputDto inputDto = TeacherDtoMapper.INSTANCE.toInputDto(teacherJpa);
//
//        assertNotNull(inputDto);
//        assertEquals("Great teacher", inputDto.getComments());
//        assertEquals(Branch.BACK, inputDto.getBranch());
    }

    @Test
    void toOutputDto() {
        Teacher teacher = new Teacher();
        teacher.setIdTeacher(1L);
        Person person = new Person();
        person.setIdPerson(1L);
        person.setUsername("johndoe");
        teacher.setPerson(person);
        teacher.setComments("Great teacher");
        teacher.setBranch(Branch.FRONT);
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setIdStudent(1L);
        students.add(student);
        teacher.setStudents(students);

        TeacherOutputDto outputDto = TeacherDtoMapper.INSTANCE.toOutputDto(teacher);

        assertNotNull(outputDto);
        assertEquals(1L, outputDto.getIdTeacher());
        assertEquals("Great teacher", outputDto.getComments());
        assertEquals(Branch.FRONT, outputDto.getBranch());
    }

    @Test
    void toOutputDtoDetails() {
        Teacher teacher = new Teacher();
        teacher.setIdTeacher(1L);
        Person person = new Person();
        person.setIdPerson(1L);
        person.setUsername("johndoe");
        teacher.setPerson(person);
        teacher.setComments("Great teacher");
        teacher.setBranch(Branch.FULLSTACK);
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setIdStudent(1L);
        students.add(student);
        teacher.setStudents(students);

        TeacherDetailsOutputDto outputDtoDetails = TeacherDtoMapper.INSTANCE.toOutputDtoDetails(teacher);

        assertNotNull(outputDtoDetails);
        assertEquals(1L, outputDtoDetails.getIdTeacher());
        assertEquals(1L, outputDtoDetails.getPerson().getIdPerson());
        assertEquals("johndoe", outputDtoDetails.getPerson().getUsername());
        assertEquals("Great teacher", outputDtoDetails.getComments());
        assertEquals(1, outputDtoDetails.getStudents().size());
        assertEquals(1L, outputDtoDetails.getStudents().getFirst().getIdStudent());
    }

    @Test
    void testToOutputDto() {
        TeacherJpa teacherJpa = new TeacherJpa();
        teacherJpa.setIdTeacher(1L);
        Person person = new Person();
        person.setIdPerson(1L);
        person.setUsername("johndoe");
        teacherJpa.setComments("Great teacher");
        teacherJpa.setBranch(Branch.BACK);
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setIdStudent(1L);
        students.add(student);

        TeacherOutputDto outputDto = TeacherDtoMapper.INSTANCE.toOutputDto(teacherJpa);

        assertNotNull(outputDto);
        assertEquals(1L, outputDto.getIdTeacher());
        assertEquals("Great teacher", outputDto.getComments());
    }

    @Test
    void toOutputDtoList() {
        List<Teacher> teachers = new ArrayList<>();
        Teacher teacher = new Teacher();
        teacher.setIdTeacher(1L);
        Person person = new Person();
        person.setIdPerson(1L);
        person.setUsername("johndoe");
        teacher.setPerson(person);
        teacher.setComments("Great teacher");
        teacher.setBranch(Branch.FRONT);
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setIdStudent(1L);
        students.add(student);
        teacher.setStudents(students);
        teachers.add(teacher);

        List<TeacherOutputDto> outputDtoList = TeacherDtoMapper.INSTANCE.toOutputDtoList(teachers);

        assertNotNull(outputDtoList);
        assertEquals(1, outputDtoList.size());
        assertEquals(1L, outputDtoList.getFirst().getIdTeacher());
        assertEquals("Great teacher", outputDtoList.getFirst().getComments());
    }
}
