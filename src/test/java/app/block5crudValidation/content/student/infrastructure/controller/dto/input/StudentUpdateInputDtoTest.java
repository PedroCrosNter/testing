package app.block5crudValidation.content.student.infrastructure.controller.dto.input;

import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentUpdateInputDtoTest {

    @Test
    void testGetIdStudent() {
        Long idStudent = 1L;
        StudentUpdateInputDto dto = new StudentUpdateInputDto();
        dto.setIdStudent(idStudent);
        assertEquals(idStudent, dto.getIdStudent());
    }

    @Test
    void testGetIdPerson() {
        Long idPerson = 1L;
        StudentUpdateInputDto dto = new StudentUpdateInputDto();
        dto.setIdPerson(idPerson);
        assertEquals(idPerson, dto.getIdPerson());
    }

    @Test
    void testGetNumHoursWeek() {
        Integer numHoursWeek = 10;
        StudentUpdateInputDto dto = new StudentUpdateInputDto();
        dto.setNumHoursWeek(numHoursWeek);
        assertEquals(numHoursWeek, dto.getNumHoursWeek());
    }

    @Test
    void testGetIdTeacher() {
        Long idTeacher = 1L;
        StudentUpdateInputDto dto = new StudentUpdateInputDto();
        dto.setIdTeacher(idTeacher);
        assertEquals(idTeacher, dto.getIdTeacher());
    }

    @Test
    void testGetBranch() {
        Branch branch = Branch.BACK;
        StudentUpdateInputDto dto = new StudentUpdateInputDto();
        dto.setBranch(branch);
        assertEquals(branch, dto.getBranch());
    }

    @Test
    void testSetIdStudent() {
        Long idStudent = 1L;
        StudentUpdateInputDto dto = new StudentUpdateInputDto();
        dto.setIdStudent(idStudent);
        assertEquals(idStudent, dto.getIdStudent());
    }

    @Test
    void testSetIdPerson() {
        Long idPerson = 1L;
        StudentUpdateInputDto dto = new StudentUpdateInputDto();
        dto.setIdPerson(idPerson);
        assertEquals(idPerson, dto.getIdPerson());
    }

    @Test
    void testSetNumHoursWeek() {
        Integer numHoursWeek = 10;
        StudentUpdateInputDto dto = new StudentUpdateInputDto();
        dto.setNumHoursWeek(numHoursWeek);
        assertEquals(numHoursWeek, dto.getNumHoursWeek());
    }

    @Test
    void testSetIdTeacher() {
        Long idTeacher = 1L;
        StudentUpdateInputDto dto = new StudentUpdateInputDto();
        dto.setIdTeacher(idTeacher);
        assertEquals(idTeacher, dto.getIdTeacher());
    }

    @Test
    void testSetBranch() {
        Branch branch = Branch.BACK;
        StudentUpdateInputDto dto = new StudentUpdateInputDto();
        dto.setBranch(branch);
        assertEquals(branch, dto.getBranch());
    }
}
