package app.block5crudValidation.content.student.domain.entity;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.shared.enums.Branch;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    private Long idStudent;
    private Person person;
    private Integer numHoursWeek;
    private Teacher teacher;
    private Branch branch;
}
