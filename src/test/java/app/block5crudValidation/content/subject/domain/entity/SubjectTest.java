package app.block5crudValidation.content.subject.domain.entity;

import app.block5crudValidation.content.student.domain.entity.Student;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubjectTest {

    @Test
    void testGetIdSubject() {
        Long id = 1L;
        Subject subject = new Subject();
        subject.setIdSubject(id);
        assertEquals(id, subject.getIdSubject());
    }

    @Test
    void testGetStudents() {
        List<Student> students = new ArrayList<>();
        Subject subject = new Subject();
        subject.setStudents(students);
        assertEquals(students, subject.getStudents());
    }

    @Test
    void testGetName() {
        String name = "Mathematics";
        Subject subject = new Subject();
        subject.setName(name);
        assertEquals(name, subject.getName());
    }

    @Test
    void testGetComment() {
        String comment = "This is a math course.";
        Subject subject = new Subject();
        subject.setComment(comment);
        assertEquals(comment, subject.getComment());
    }

    @Test
    void testGetInitialDate() {
        LocalDate initialDate = LocalDate.of(2024, 6, 1);
        Subject subject = new Subject();
        subject.setInitialDate(initialDate);
        assertEquals(initialDate, subject.getInitialDate());
    }

    @Test
    void testGetFinishDate() {
        LocalDate finishDate = LocalDate.of(2024, 7, 1);
        Subject subject = new Subject();
        subject.setFinishDate(finishDate);
        assertEquals(finishDate, subject.getFinishDate());
    }

    @Test
    void testSetIdSubject() {
        Long id = 1L;
        Subject subject = new Subject();
        subject.setIdSubject(id);
        assertEquals(id, subject.getIdSubject());
    }

    @Test
    void testSetStudents() {
        List<Student> students = new ArrayList<>();
        Subject subject = new Subject();
        subject.setStudents(students);
        assertEquals(students, subject.getStudents());
    }

    @Test
    void testSetName() {
        String name = "Mathematics";
        Subject subject = new Subject();
        subject.setName(name);
        assertEquals(name, subject.getName());
    }

    @Test
    void testSetComment() {
        String comment = "This is a math course.";
        Subject subject = new Subject();
        subject.setComment(comment);
        assertEquals(comment, subject.getComment());
    }

    @Test
    void testSetInitialDate() {
        LocalDate initialDate = LocalDate.of(2024, 6, 1);
        Subject subject = new Subject();
        subject.setInitialDate(initialDate);
        assertEquals(initialDate, subject.getInitialDate());
    }

    @Test
    void testSetFinishDate() {
        LocalDate finishDate = LocalDate.of(2024, 7, 1);
        Subject subject = new Subject();
        subject.setFinishDate(finishDate);
        assertEquals(finishDate, subject.getFinishDate());
    }
}
