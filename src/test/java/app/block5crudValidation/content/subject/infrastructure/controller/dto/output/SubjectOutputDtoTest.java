package app.block5crudValidation.content.subject.infrastructure.controller.dto.output;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class SubjectOutputDtoTest {

    @Test
    void testGetIdSubject() {
        Long idSubject = 123L;
        SubjectOutputDto dto = new SubjectOutputDto();
        dto.setIdSubject(idSubject);
        assertEquals(idSubject, dto.getIdSubject());
    }

    @Test
    void testGetName() {
        String name = "Mathematics";
        SubjectOutputDto dto = new SubjectOutputDto();
        dto.setName(name);
        assertEquals(name, dto.getName());
    }

    @Test
    void testGetInitialDate() {
        LocalDate initialDate = LocalDate.of(2024, 6, 1);
        SubjectOutputDto dto = new SubjectOutputDto();
        dto.setInitialDate(initialDate);
        assertEquals(initialDate, dto.getInitialDate());
    }

    @Test
    void testSetIdSubject() {
        Long idSubject = 123L;
        SubjectOutputDto dto = new SubjectOutputDto();
        dto.setIdSubject(idSubject);
        assertEquals(idSubject, dto.getIdSubject());
    }

    @Test
    void testSetName() {
        String name = "Mathematics";
        SubjectOutputDto dto = new SubjectOutputDto();
        dto.setName(name);
        assertEquals(name, dto.getName());
    }

    @Test
    void testSetInitialDate() {
        LocalDate initialDate = LocalDate.of(2024, 6, 1);
        SubjectOutputDto dto = new SubjectOutputDto();
        dto.setInitialDate(initialDate);
        assertEquals(initialDate, dto.getInitialDate());
    }
}
