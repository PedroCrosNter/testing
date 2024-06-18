package app.block5crudValidation.content.subject.infrastructure.controller.dto.input;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class SubjectCreateInputDtoTest {

    @Test
    void testGetIdStudent() {
        Long idStudent = 123L;
        SubjectCreateInputDto dto = new SubjectCreateInputDto();
        dto.setIdStudent(idStudent);
        assertEquals(idStudent, dto.getIdStudent());
    }

    @Test
    void testGetName() {
        String name = "Mathematics";
        SubjectCreateInputDto dto = new SubjectCreateInputDto();
        dto.setName(name);
        assertEquals(name, dto.getName());
    }

    @Test
    void testGetComment() {
        String comment = "This subject covers algebra and calculus.";
        SubjectCreateInputDto dto = new SubjectCreateInputDto();
        dto.setComment(comment);
        assertEquals(comment, dto.getComment());
    }

    @Test
    void testGetInitialDate() {
        LocalDate initialDate = LocalDate.of(2024, 6, 1);
        SubjectCreateInputDto dto = new SubjectCreateInputDto();
        dto.setInitialDate(initialDate);
        assertEquals(initialDate, dto.getInitialDate());
    }

    @Test
    void testGetFinishDate() {
        LocalDate finishDate = LocalDate.of(2024, 6, 30);
        SubjectCreateInputDto dto = new SubjectCreateInputDto();
        dto.setFinishDate(finishDate);
        assertEquals(finishDate, dto.getFinishDate());
    }

    @Test
    void testSetIdStudent() {
        Long idStudent = 123L;
        SubjectCreateInputDto dto = new SubjectCreateInputDto();
        dto.setIdStudent(idStudent);
        assertEquals(idStudent, dto.getIdStudent());
    }

    @Test
    void testSetName() {
        String name = "Mathematics";
        SubjectCreateInputDto dto = new SubjectCreateInputDto();
        dto.setName(name);
        assertEquals(name, dto.getName());
    }

    @Test
    void testSetComment() {
        String comment = "This subject covers algebra and calculus.";
        SubjectCreateInputDto dto = new SubjectCreateInputDto();
        dto.setComment(comment);
        assertEquals(comment, dto.getComment());
    }

    @Test
    void testSetInitialDate() {
        LocalDate initialDate = LocalDate.of(2024, 6, 1);
        SubjectCreateInputDto dto = new SubjectCreateInputDto();
        dto.setInitialDate(initialDate);
        assertEquals(initialDate, dto.getInitialDate());
    }

    @Test
    void testSetFinishDate() {
        LocalDate finishDate = LocalDate.of(2024, 6, 30);
        SubjectCreateInputDto dto = new SubjectCreateInputDto();
        dto.setFinishDate(finishDate);
        assertEquals(finishDate, dto.getFinishDate());
    }
}
