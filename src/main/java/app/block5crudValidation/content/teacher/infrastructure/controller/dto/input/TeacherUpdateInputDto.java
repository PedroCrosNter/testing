package app.block5crudValidation.content.teacher.infrastructure.controller.dto.input;

import app.block5crudValidation.shared.enums.Branch;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherUpdateInputDto {

    @NonNull
    private Long idTeacher;

    @NonNull
    private Long idPerson;

    @NonNull
    private String comments;

    @NonNull
    private Branch branch;
}
