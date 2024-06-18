package app.block5crudValidation.content.student.infrastructure.controller.dto.output;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentDetailsOutputDtoTest {

    @Test
    void testGetIdStudent() {
        Long idStudent = 1L;
        StudentDetailsOutputDto dto = new StudentDetailsOutputDto();
        dto.setIdStudent(idStudent);
        assertEquals(idStudent, dto.getIdStudent());
    }

    @Test
    void testGetPerson() {
        Person person = new Person();
        StudentDetailsOutputDto dto = new StudentDetailsOutputDto();
        dto.setPerson(person);
        assertEquals(person, dto.getPerson());
    }

    @Test
    void testGetNumHoursWeek() {
        Integer numHoursWeek = 10;
        StudentDetailsOutputDto dto = new StudentDetailsOutputDto();
        dto.setNumHoursWeek(numHoursWeek);
        assertEquals(numHoursWeek, dto.getNumHoursWeek());
    }

    @Test
    void testGetTeacher() {
        Teacher teacher = new Teacher();
        StudentDetailsOutputDto dto = new StudentDetailsOutputDto();
        dto.setTeacher(teacher);
        assertEquals(teacher, dto.getTeacher());
    }

    @Test
    void testGetBranch() {
        Branch branch = Branch.BACK;
        StudentDetailsOutputDto dto = new StudentDetailsOutputDto();
        dto.setBranch(branch);
        assertEquals(branch, dto.getBranch());
    }

    @Test
    void testSetIdStudent() {
        Long idStudent = 1L;
        StudentDetailsOutputDto dto = new StudentDetailsOutputDto();
        dto.setIdStudent(idStudent);
        assertEquals(idStudent, dto.getIdStudent());
    }

    @Test
    void testSetPerson() {
        Person person = new Person();
        StudentDetailsOutputDto dto = new StudentDetailsOutputDto();
        dto.setPerson(person);
        assertEquals(person, dto.getPerson());
    }

    @Test
    void testSetNumHoursWeek() {
        Integer numHoursWeek = 10;
        StudentDetailsOutputDto dto = new StudentDetailsOutputDto();
        dto.setNumHoursWeek(numHoursWeek);
        assertEquals(numHoursWeek, dto.getNumHoursWeek());
    }

    @Test
    void testSetTeacher() {
        Teacher teacher = new Teacher();
        StudentDetailsOutputDto dto = new StudentDetailsOutputDto();
        dto.setTeacher(teacher);
        assertEquals(teacher, dto.getTeacher());
    }

    @Test
    void testSetBranch() {
        Branch branch = Branch.BACK;
        StudentDetailsOutputDto dto = new StudentDetailsOutputDto();
        dto.setBranch(branch);
        assertEquals(branch, dto.getBranch());
    }
}
