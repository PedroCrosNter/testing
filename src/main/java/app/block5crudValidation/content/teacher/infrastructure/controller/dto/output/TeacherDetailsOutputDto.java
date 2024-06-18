package app.block5crudValidation.content.teacher.infrastructure.controller.dto.output;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.shared.enums.Branch;
import app.block5crudValidation.content.student.domain.entity.Student;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherDetailsOutputDto {

    @NonNull
    private Long idTeacher;

    @NonNull
    private String comments;

    @NonNull
    private Branch branch;

    Person person;

    List<Student> students;
}
