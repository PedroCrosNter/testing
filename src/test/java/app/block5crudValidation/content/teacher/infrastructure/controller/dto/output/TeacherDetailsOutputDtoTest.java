package app.block5crudValidation.content.teacher.infrastructure.controller.dto.output;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeacherDetailsOutputDtoTest {

    @Test
    void testGetIdTeacher() {
        Long idTeacher = 123L;
        TeacherDetailsOutputDto dto = new TeacherDetailsOutputDto();
        dto.setIdTeacher(idTeacher);
        assertEquals(idTeacher, dto.getIdTeacher());
    }

    @Test
    void testGetComments() {
        String comments = "Good teacher";
        TeacherDetailsOutputDto dto = new TeacherDetailsOutputDto();
        dto.setComments(comments);
        assertEquals(comments, dto.getComments());
    }

    @Test
    void testGetBranch() {
        Branch branch = Branch.BACK;
        TeacherDetailsOutputDto dto = new TeacherDetailsOutputDto();
        dto.setBranch(branch);
        assertEquals(branch, dto.getBranch());
    }

    @Test
    void testGetPerson() {
        Person person = new Person();
        TeacherDetailsOutputDto dto = new TeacherDetailsOutputDto();
        dto.setPerson(person);
        assertEquals(person, dto.getPerson());
    }

    @Test
    void testGetStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student());
        TeacherDetailsOutputDto dto = new TeacherDetailsOutputDto();
        dto.setStudents(students);
        assertEquals(students, dto.getStudents());
    }

    @Test
    void testSetIdTeacher() {
        Long idTeacher = 123L;
        TeacherDetailsOutputDto dto = new TeacherDetailsOutputDto();
        dto.setIdTeacher(idTeacher);
        assertEquals(idTeacher, dto.getIdTeacher());
    }

    @Test
    void testSetComments() {
        String comments = "Good teacher";
        TeacherDetailsOutputDto dto = new TeacherDetailsOutputDto();
        dto.setComments(comments);
        assertEquals(comments, dto.getComments());
    }

    @Test
    void testSetBranch() {
        Branch branch = Branch.BACK;
        TeacherDetailsOutputDto dto = new TeacherDetailsOutputDto();
        dto.setBranch(branch);
        assertEquals(branch, dto.getBranch());
    }

    @Test
    void testSetPerson() {
        Person person = new Person();
        TeacherDetailsOutputDto dto = new TeacherDetailsOutputDto();
        dto.setPerson(person);
        assertEquals(person, dto.getPerson());
    }

    @Test
    void testSetStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student());
        TeacherDetailsOutputDto dto = new TeacherDetailsOutputDto();
        dto.setStudents(students);
        assertEquals(students, dto.getStudents());
    }
}
