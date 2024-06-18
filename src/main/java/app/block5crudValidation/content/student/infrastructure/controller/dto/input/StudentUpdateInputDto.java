package app.block5crudValidation.content.student.infrastructure.controller.dto.input;

import app.block5crudValidation.shared.enums.Branch;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentUpdateInputDto {

    @NonNull
    private Long idStudent;

    @NonNull // Foreign key
    private Long idPerson;

    @NonNull
    private Integer numHoursWeek;

    @NonNull // Foreign key
    private Long idTeacher;

    @NonNull
    private Branch branch;
}
