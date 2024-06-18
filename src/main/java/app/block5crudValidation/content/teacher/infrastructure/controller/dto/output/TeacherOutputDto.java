package app.block5crudValidation.content.teacher.infrastructure.controller.dto.output;

import app.block5crudValidation.shared.enums.Branch;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherOutputDto {

    @NonNull
    private Long idTeacher;

    @NonNull
    private String comments;

    @NonNull
    private Branch branch;
}
