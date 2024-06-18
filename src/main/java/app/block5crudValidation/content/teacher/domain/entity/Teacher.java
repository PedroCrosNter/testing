package app.block5crudValidation.content.teacher.domain.entity;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.shared.enums.Branch;
import app.block5crudValidation.content.student.domain.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    private Long idTeacher;
    private Person person;
    private String comments;
    private Branch branch;
    private List<Student> students;
}
