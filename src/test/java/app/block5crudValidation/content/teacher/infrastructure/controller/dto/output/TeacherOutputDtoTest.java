package app.block5crudValidation.content.teacher.infrastructure.controller.dto.output;

import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeacherOutputDtoTest {

    @Test
    void testGetIdTeacher() {
        Long idTeacher = 123L;
        TeacherOutputDto dto = new TeacherOutputDto();
        dto.setIdTeacher(idTeacher);
        assertEquals(idTeacher, dto.getIdTeacher());
    }

    @Test
    void testGetComments() {
        String comments = "Good teacher";
        TeacherOutputDto dto = new TeacherOutputDto();
        dto.setComments(comments);
        assertEquals(comments, dto.getComments());
    }

    @Test
    void testGetBranch() {
        Branch branch = Branch.BACK;
        TeacherOutputDto dto = new TeacherOutputDto();
        dto.setBranch(branch);
        assertEquals(branch, dto.getBranch());
    }

    @Test
    void testSetIdTeacher() {
        Long idTeacher = 123L;
        TeacherOutputDto dto = new TeacherOutputDto();
        dto.setIdTeacher(idTeacher);
        assertEquals(idTeacher, dto.getIdTeacher());
    }

    @Test
    void testSetComments() {
        String comments = "Good teacher";
        TeacherOutputDto dto = new TeacherOutputDto();
        dto.setComments(comments);
        assertEquals(comments, dto.getComments());
    }

    @Test
    void testSetBranch() {
        Branch branch = Branch.BACK;
        TeacherOutputDto dto = new TeacherOutputDto();
        dto.setBranch(branch);
        assertEquals(branch, dto.getBranch());
    }
}
