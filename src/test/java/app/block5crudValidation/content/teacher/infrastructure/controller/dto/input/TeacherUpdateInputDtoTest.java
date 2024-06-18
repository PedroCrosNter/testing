package app.block5crudValidation.content.teacher.infrastructure.controller.dto.input;

import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeacherUpdateInputDtoTest {

    @Test
    void testGetIdTeacher() {
        Long idTeacher = 123L;
        TeacherUpdateInputDto dto = new TeacherUpdateInputDto();
        dto.setIdTeacher(idTeacher);
        assertEquals(idTeacher, dto.getIdTeacher());
    }

    @Test
    void testGetIdPerson() {
        Long idPerson = 123L;
        TeacherUpdateInputDto dto = new TeacherUpdateInputDto();
        dto.setIdPerson(idPerson);
        assertEquals(idPerson, dto.getIdPerson());
    }

    @Test
    void testGetComments() {
        String comments = "Good teacher";
        TeacherUpdateInputDto dto = new TeacherUpdateInputDto();
        dto.setComments(comments);
        assertEquals(comments, dto.getComments());
    }

    @Test
    void testGetBranch() {
        Branch branch = Branch.BACK;
        TeacherUpdateInputDto dto = new TeacherUpdateInputDto();
        dto.setBranch(branch);
        assertEquals(branch, dto.getBranch());
    }

    @Test
    void testSetIdTeacher() {
        Long idTeacher = 123L;
        TeacherUpdateInputDto dto = new TeacherUpdateInputDto();
        dto.setIdTeacher(idTeacher);
        assertEquals(idTeacher, dto.getIdTeacher());
    }

    @Test
    void testSetIdPerson() {
        Long idPerson = 123L;
        TeacherUpdateInputDto dto = new TeacherUpdateInputDto();
        dto.setIdPerson(idPerson);
        assertEquals(idPerson, dto.getIdPerson());
    }

    @Test
    void testSetComments() {
        String comments = "Good teacher";
        TeacherUpdateInputDto dto = new TeacherUpdateInputDto();
        dto.setComments(comments);
        assertEquals(comments, dto.getComments());
    }

    @Test
    void testSetBranch() {
        Branch branch = Branch.BACK;
        TeacherUpdateInputDto dto = new TeacherUpdateInputDto();
        dto.setBranch(branch);
        assertEquals(branch, dto.getBranch());
    }
}
