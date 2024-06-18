package app.block5crudValidation.content.student.infrastructure.controller.dto.output;

import app.block5crudValidation.shared.enums.Branch;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentOutputDto {


//    @NonNull
    private Integer numHoursWeek;

//    @NonNull
    private Branch branch;


//    @PostConstruct
//    public void init() {
//        if (numHoursWeek == null) {
//            numHoursWeek = 0;
//        }
//        if (branch == null) {
//            branch = Branch.UNASSIGNED;
//        }
//    }


//    @Builder
//    public StudentOutputDto(Integer numHoursWeek, Branch branch) {
//        this.numHoursWeek = numHoursWeek != null ? numHoursWeek : 0;
//        this.branch = branch != null ? branch : Branch.UNASSIGNED;
//    }
}
