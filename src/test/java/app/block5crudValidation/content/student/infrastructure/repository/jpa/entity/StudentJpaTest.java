package app.block5crudValidation.content.student.infrastructure.repository.jpa.entity;

import app.block5crudValidation.content.person.infrastructure.repository.jpa.entity.PersonJpa;
import app.block5crudValidation.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentJpaTest {

    @Test
    void testAddSubject() {
        StudentJpa student = new StudentJpa();
        SubjectJpa subject = new SubjectJpa();

        student.addSubject(subject);

        assertTrue(student.getSubjects().contains(subject));
    }

    @Test
    void testRemoveSubject() {
        StudentJpa student = new StudentJpa();
        SubjectJpa subject = new SubjectJpa();
        student.addSubject(subject);

        student.removeSubject(subject);

        assertFalse(student.getSubjects().contains(subject));
    }

    @Test
    void testGetIdStudent() {
        StudentJpa student = new StudentJpa();
        student.setIdStudent(1L);
        assertEquals(1L, student.getIdStudent());
    }

    @Test
    void testGetPersonJpa() {
        StudentJpa student = new StudentJpa();
        PersonJpa person = new PersonJpa();
        student.setPersonJpa(person);
        assertEquals(person, student.getPersonJpa());
    }

    @Test
    void testGetNumHoursWeek() {
        StudentJpa student = new StudentJpa();
        student.setNumHoursWeek(20);
        assertEquals(20, student.getNumHoursWeek());
    }

    @Test
    void testGetTeacherJpa() {
        StudentJpa student = new StudentJpa();
        TeacherJpa teacher = new TeacherJpa();
        student.setTeacherJpa(teacher);
        assertEquals(teacher, student.getTeacherJpa());
    }

    @Test
    void testGetBranch() {
        StudentJpa student = new StudentJpa();
        student.setBranch(Branch.BACK);
        assertEquals(Branch.BACK, student.getBranch());
    }

    @Test
    void testGetSubjects() {
        StudentJpa student = new StudentJpa();
        List<SubjectJpa> subjects = new ArrayList<>();
        student.setSubjects(subjects);
        assertEquals(subjects, student.getSubjects());
    }

    @Test
    void testSetIdStudent() {
        StudentJpa student = new StudentJpa();
        student.setIdStudent(1L);
        assertEquals(1L, student.getIdStudent());
    }

    @Test
    void testSetPersonJpa() {
        StudentJpa student = new StudentJpa();
        PersonJpa person = new PersonJpa();
        student.setPersonJpa(person);
        assertEquals(person, student.getPersonJpa());
    }

    @Test
    void testSetNumHoursWeek() {
        StudentJpa student = new StudentJpa();
        student.setNumHoursWeek(20);
        assertEquals(20, student.getNumHoursWeek());
    }

    @Test
    void testSetTeacherJpa() {
        StudentJpa student = new StudentJpa();
        TeacherJpa teacher = new TeacherJpa();
        student.setTeacherJpa(teacher);
        assertEquals(teacher, student.getTeacherJpa());
    }

    @Test
    void testSetBranch() {
        StudentJpa student = new StudentJpa();
        student.setBranch(Branch.BACK);
        assertEquals(Branch.BACK, student.getBranch());
    }

    @Test
    void testSetSubjects() {
        StudentJpa student = new StudentJpa();
        List<SubjectJpa> subjects = new ArrayList<>();
        student.setSubjects(subjects);
        assertEquals(subjects, student.getSubjects());
    }
}
