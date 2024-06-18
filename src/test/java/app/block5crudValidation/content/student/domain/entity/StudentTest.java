package app.block5crudValidation.content.student.domain.entity;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    @Test
    void testGetIdStudent() {
        Long id = 1L;
        Student student = new Student();
        student.setIdStudent(id);
        assertEquals(id, student.getIdStudent());
    }

    @Test
    void testGetPerson() {
        Person person = new Person();
        Student student = new Student();
        student.setPerson(person);
        assertEquals(person, student.getPerson());
    }

    @Test
    void testGetNumHoursWeek() {
        Integer numHours = 20;
        Student student = new Student();
        student.setNumHoursWeek(numHours);
        assertEquals(numHours, student.getNumHoursWeek());
    }

    @Test
    void testGetTeacher() {
        Teacher teacher = new Teacher();
        Student student = new Student();
        student.setTeacher(teacher);
        assertEquals(teacher, student.getTeacher());
    }

    @Test
    void testGetBranch() {
        Branch branch = Branch.BACK;
        Student student = new Student();
        student.setBranch(branch);
        assertEquals(branch, student.getBranch());
    }

    @Test
    void testSetIdStudent() {
        Long id = 1L;
        Student student = new Student();
        student.setIdStudent(id);
        assertEquals(id, student.getIdStudent());
    }

    @Test
    void testSetPerson() {
        Person person = new Person();
        Student student = new Student();
        student.setPerson(person);
        assertEquals(person, student.getPerson());
    }

    @Test
    void testSetNumHoursWeek() {
        Integer numHours = 20;
        Student student = new Student();
        student.setNumHoursWeek(numHours);
        assertEquals(numHours, student.getNumHoursWeek());
    }

    @Test
    void testSetTeacher() {
        Teacher teacher = new Teacher();
        Student student = new Student();
        student.setTeacher(teacher);
        assertEquals(teacher, student.getTeacher());
    }

    @Test
    void testSetBranch() {
        Branch branch = Branch.BACK;
        Student student = new Student();
        student.setBranch(branch);
        assertEquals(branch, student.getBranch());
    }
}
