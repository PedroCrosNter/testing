package app.block5crudValidation.content.student.infrastructure.controller.dto.output;

import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentOutputDtoTest {

    @Test
    void testGetNumHoursWeek() {
        Integer numHoursWeek = 10;
        StudentOutputDto dto = new StudentOutputDto();
        dto.setNumHoursWeek(numHoursWeek);
        assertEquals(numHoursWeek, dto.getNumHoursWeek());
    }

    @Test
    void testGetBranch() {
        Branch branch = Branch.BACK;
        StudentOutputDto dto = new StudentOutputDto();
        dto.setBranch(branch);
        assertEquals(branch, dto.getBranch());
    }

    @Test
    void testSetNumHoursWeek() {
        Integer numHoursWeek = 10;
        StudentOutputDto dto = new StudentOutputDto();
        dto.setNumHoursWeek(numHoursWeek);
        assertEquals(numHoursWeek, dto.getNumHoursWeek());
    }

    @Test
    void testSetBranch() {
        Branch branch = Branch.BACK;
        StudentOutputDto dto = new StudentOutputDto();
        dto.setBranch(branch);
        assertEquals(branch, dto.getBranch());
    }
}
