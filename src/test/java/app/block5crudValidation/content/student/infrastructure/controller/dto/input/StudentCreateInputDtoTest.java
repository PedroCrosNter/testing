package app.block5crudValidation.content.student.infrastructure.controller.dto.input;

import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentCreateInputDtoTest {

    @Test
    void testGetIdPerson() {
        Long idPerson = 1L;
        StudentCreateInputDto dto = new StudentCreateInputDto();
        dto.setIdPerson(idPerson);
        assertEquals(idPerson, dto.getIdPerson());
    }

    @Test
    void testGetNumHoursWeek() {
        Integer numHoursWeek = 10;
        StudentCreateInputDto dto = new StudentCreateInputDto();
        dto.setNumHoursWeek(numHoursWeek);
        assertEquals(numHoursWeek, dto.getNumHoursWeek());
    }

    @Test
    void testGetIdTeacher() {
        Long idTeacher = 1L;
        StudentCreateInputDto dto = new StudentCreateInputDto();
        dto.setIdTeacher(idTeacher);
        assertEquals(idTeacher, dto.getIdTeacher());
    }

    @Test
    void testGetBranch() {
        Branch branch = Branch.BACK;
        StudentCreateInputDto dto = new StudentCreateInputDto();
        dto.setBranch(branch);
        assertEquals(branch, dto.getBranch());
    }

    @Test
    void testSetIdPerson() {
        Long idPerson = 1L;
        StudentCreateInputDto dto = new StudentCreateInputDto();
        dto.setIdPerson(idPerson);
        assertEquals(idPerson, dto.getIdPerson());
    }

    @Test
    void testSetNumHoursWeek() {
        Integer numHoursWeek = 10;
        StudentCreateInputDto dto = new StudentCreateInputDto();
        dto.setNumHoursWeek(numHoursWeek);
        assertEquals(numHoursWeek, dto.getNumHoursWeek());
    }

    @Test
    void testSetIdTeacher() {
        Long idTeacher = 1L;
        StudentCreateInputDto dto = new StudentCreateInputDto();
        dto.setIdTeacher(idTeacher);
        assertEquals(idTeacher, dto.getIdTeacher());
    }

    @Test
    void testSetBranch() {
        Branch branch = Branch.BACK;
        StudentCreateInputDto dto = new StudentCreateInputDto();
        dto.setBranch(branch);
        assertEquals(branch, dto.getBranch());
    }
}
