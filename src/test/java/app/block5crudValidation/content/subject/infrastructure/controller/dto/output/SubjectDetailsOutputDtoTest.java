package app.block5crudValidation.content.subject.infrastructure.controller.dto.output;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class SubjectDetailsOutputDtoTest {

    @Test
    void testGetIdSubject() {
        Long idSubject = 123L;
        SubjectDetailsOutputDto dto = new SubjectDetailsOutputDto();
        dto.setIdSubject(idSubject);
        assertEquals(idSubject, dto.getIdSubject());
    }

    @Test
    void testGetIdStudent() {
        Long idStudent = 456L;
        SubjectDetailsOutputDto dto = new SubjectDetailsOutputDto();
        dto.setIdStudent(idStudent);
        assertEquals(idStudent, dto.getIdStudent());
    }

    @Test
    void testGetName() {
        String name = "Mathematics";
        SubjectDetailsOutputDto dto = new SubjectDetailsOutputDto();
        dto.setName(name);
        assertEquals(name, dto.getName());
    }

    @Test
    void testGetComments() {
        String comments = "This subject covers algebra and calculus.";
        SubjectDetailsOutputDto dto = new SubjectDetailsOutputDto();
        dto.setComments(comments);
        assertEquals(comments, dto.getComments());
    }

    @Test
    void testGetInitialDate() {
        LocalDate initialDate = LocalDate.of(2024, 6, 1);
        SubjectDetailsOutputDto dto = new SubjectDetailsOutputDto();
        dto.setInitialDate(initialDate);
        assertEquals(initialDate, dto.getInitialDate());
    }

    @Test
    void testGetFinishDate() {
        LocalDate finishDate = LocalDate.of(2024, 6, 30);
        SubjectDetailsOutputDto dto = new SubjectDetailsOutputDto();
        dto.setFinishDate(finishDate);
        assertEquals(finishDate, dto.getFinishDate());
    }

    @Test
    void testSetIdSubject() {
        Long idSubject = 123L;
        SubjectDetailsOutputDto dto = new SubjectDetailsOutputDto();
        dto.setIdSubject(idSubject);
        assertEquals(idSubject, dto.getIdSubject());
    }

    @Test
    void testSetIdStudent() {
        Long idStudent = 456L;
        SubjectDetailsOutputDto dto = new SubjectDetailsOutputDto();
        dto.setIdStudent(idStudent);
        assertEquals(idStudent, dto.getIdStudent());
    }

    @Test
    void testSetName() {
        String name = "Mathematics";
        SubjectDetailsOutputDto dto = new SubjectDetailsOutputDto();
        dto.setName(name);
        assertEquals(name, dto.getName());
    }

    @Test
    void testSetComments() {
        String comments = "This subject covers algebra and calculus.";
        SubjectDetailsOutputDto dto = new SubjectDetailsOutputDto();
        dto.setComments(comments);
        assertEquals(comments, dto.getComments());
    }

    @Test
    void testSetInitialDate() {
        LocalDate initialDate = LocalDate.of(2024, 6, 1);
        SubjectDetailsOutputDto dto = new SubjectDetailsOutputDto();
        dto.setInitialDate(initialDate);
        assertEquals(initialDate, dto.getInitialDate());
    }

    @Test
    void testSetFinishDate() {
        LocalDate finishDate = LocalDate.of(2024, 6, 30);
        SubjectDetailsOutputDto dto = new SubjectDetailsOutputDto();
        dto.setFinishDate(finishDate);
        assertEquals(finishDate, dto.getFinishDate());
    }
}
