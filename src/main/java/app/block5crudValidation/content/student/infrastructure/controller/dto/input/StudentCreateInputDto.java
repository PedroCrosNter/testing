package app.block5crudValidation.content.student.infrastructure.controller.dto.input;

import app.block5crudValidation.shared.enums.Branch;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentCreateInputDto {

    @NonNull
    private Long idPerson;

    @NonNull
    private Integer numHoursWeek;

    @NonNull
    private Long idTeacher;

    @NonNull
    private Branch branch;
}
