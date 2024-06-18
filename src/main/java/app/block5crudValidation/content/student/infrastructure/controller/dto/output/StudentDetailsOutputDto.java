package app.block5crudValidation.content.student.infrastructure.controller.dto.output;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.shared.enums.Branch;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDetailsOutputDto {

    @NonNull
    private Long idStudent;

    @NonNull // Foreign key
    private Person person;

    @NonNull
    private Integer numHoursWeek;

    private Teacher teacher;

    @NonNull
    private Branch branch;
}
