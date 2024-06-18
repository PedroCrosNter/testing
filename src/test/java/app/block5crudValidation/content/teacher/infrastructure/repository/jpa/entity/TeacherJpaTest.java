package app.block5crudValidation.content.teacher.infrastructure.repository.jpa.entity;

import app.block5crudValidation.content.person.infrastructure.repository.jpa.entity.PersonJpa;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeacherJpaTest {

    @Test
    void testGettersAndSetters() {
        TeacherJpa teacher = new TeacherJpa();

        // Set values
        Long idTeacher = 1L;
        PersonJpa personJpa = new PersonJpa();
        String comments = "Some comments";
        Branch branch = Branch.BACK;
        List<StudentJpa> students = new ArrayList<>();

        teacher.setIdTeacher(idTeacher);
        teacher.setPersonJpa(personJpa);
        teacher.setComments(comments);
        teacher.setBranch(branch);
        teacher.setStudents(students);

        // Verify values
        assertEquals(idTeacher, teacher.getIdTeacher());
        assertEquals(personJpa, teacher.getPersonJpa());
        assertEquals(comments, teacher.getComments());
        assertEquals(branch, teacher.getBranch());
        assertEquals(students, teacher.getStudents());
    }
}
