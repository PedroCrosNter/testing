package app.block5crudValidation.content.teacher.domain.entity;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeacherTest {

    @Test
    void testGetIdTeacher() {
        Long id = 1L;
        Teacher teacher = new Teacher();
        teacher.setIdTeacher(id);
        assertEquals(id, teacher.getIdTeacher());
    }

    @Test
    void testGetPerson() {
        Person person = new Person();
        Teacher teacher = new Teacher();
        teacher.setPerson(person);
        assertEquals(person, teacher.getPerson());
    }

    @Test
    void testGetComments() {
        String comments = "Excellent teacher!";
        Teacher teacher = new Teacher();
        teacher.setComments(comments);
        assertEquals(comments, teacher.getComments());
    }

    @Test
    void testGetBranch() {
        Branch branch = Branch.BACK;
        Teacher teacher = new Teacher();
        teacher.setBranch(branch);
        assertEquals(branch, teacher.getBranch());
    }

    @Test
    void testGetStudents() {
        List<Student> students = new ArrayList<>();
        Teacher teacher = new Teacher();
        teacher.setStudents(students);
        assertEquals(students, teacher.getStudents());
    }

    @Test
    void testSetIdTeacher() {
        Long id = 1L;
        Teacher teacher = new Teacher();
        teacher.setIdTeacher(id);
        assertEquals(id, teacher.getIdTeacher());
    }

    @Test
    void testSetPerson() {
        Person person = new Person();
        Teacher teacher = new Teacher();
        teacher.setPerson(person);
        assertEquals(person, teacher.getPerson());
    }

    @Test
    void testSetComments() {
        String comments = "Excellent teacher!";
        Teacher teacher = new Teacher();
        teacher.setComments(comments);
        assertEquals(comments, teacher.getComments());
    }

    @Test
    void testSetBranch() {
        Branch branch = Branch.BACK;
        Teacher teacher = new Teacher();
        teacher.setBranch(branch);
        assertEquals(branch, teacher.getBranch());
    }

    @Test
    void testSetStudents() {
        List<Student> students = new ArrayList<>();
        Teacher teacher = new Teacher();
        teacher.setStudents(students);
        assertEquals(students, teacher.getStudents());
    }
}
