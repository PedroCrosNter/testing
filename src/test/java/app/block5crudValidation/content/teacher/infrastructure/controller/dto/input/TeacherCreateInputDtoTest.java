package app.block5crudValidation.content.teacher.infrastructure.controller.dto.input;

import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeacherCreateInputDtoTest {

    @Test
    void testGetIdPerson() {
        Long idPerson = 123L;
        TeacherCreateInputDto dto = new TeacherCreateInputDto();
        dto.setIdPerson(idPerson);
        assertEquals(idPerson, dto.getIdPerson());
    }

    @Test
    void testGetComments() {
        String comments = "Good teacher";
        TeacherCreateInputDto dto = new TeacherCreateInputDto();
        dto.setComments(comments);
        assertEquals(comments, dto.getComments());
    }

    @Test
    void testGetBranch() {
        Branch branch = Branch.BACK;
        TeacherCreateInputDto dto = new TeacherCreateInputDto();
        dto.setBranch(branch);
        assertEquals(branch, dto.getBranch());
    }

    @Test
    void testSetIdPerson() {
        Long idPerson = 123L;
        TeacherCreateInputDto dto = new TeacherCreateInputDto();
        dto.setIdPerson(idPerson);
        assertEquals(idPerson, dto.getIdPerson());
    }

    @Test
    void testSetComments() {
        String comments = "Good teacher";
        TeacherCreateInputDto dto = new TeacherCreateInputDto();
        dto.setComments(comments);
        assertEquals(comments, dto.getComments());
    }

    @Test
    void testSetBranch() {
        Branch branch = Branch.BACK;
        TeacherCreateInputDto dto = new TeacherCreateInputDto();
        dto.setBranch(branch);
        assertEquals(branch, dto.getBranch());
    }
}
