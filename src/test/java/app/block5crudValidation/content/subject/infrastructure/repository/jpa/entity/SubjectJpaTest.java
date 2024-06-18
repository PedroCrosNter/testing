package app.block5crudValidation.content.subject.infrastructure.repository.jpa.entity;

import app.block5crudValidation.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubjectJpaTest {

    @Test
    void testGettersAndSetters() {
        SubjectJpa subject = new SubjectJpa();

        // Set values
        Long idSubject = 1L;
        List<StudentJpa> students = new ArrayList<>();
        String name = "Mathematics";
        String comment = "Some comments";
        LocalDate initialDate = LocalDate.of(2024, 6, 1);
        LocalDate finishDate = LocalDate.of(2024, 7, 1);

        subject.setIdSubject(idSubject);
        subject.setStudents(students);
        subject.setName(name);
        subject.setComment(comment);
        subject.setInitialDate(initialDate);
        subject.setFinishDate(finishDate);

        // Verify values
        assertEquals(idSubject, subject.getIdSubject());
        assertEquals(students, subject.getStudents());
        assertEquals(name, subject.getName());
        assertEquals(comment, subject.getComment());
        assertEquals(initialDate, subject.getInitialDate());
        assertEquals(finishDate, subject.getFinishDate());
    }
}
