package app.block5crudValidation.content.student.application.mapper;

import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.student.infrastructure.controller.dto.input.StudentCreateInputDto;
import app.block5crudValidation.content.student.infrastructure.controller.dto.output.StudentDetailsOutputDto;
import app.block5crudValidation.content.student.infrastructure.controller.dto.output.StudentOutputDto;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentDtoMapper {

        StudentDtoMapper INSTANCE = Mappers.getMapper(StudentDtoMapper.class);


        StudentCreateInputDto toInputDto(Student student);

        StudentCreateInputDto toInputDto(StudentJpa studentJpa);


        @Mappings({
                @Mapping(source = "numHoursWeek", target = "numHoursWeek"),
                @Mapping(source = "branch", target = "branch")
        })
        StudentOutputDto toOutputDto(Student student);

        @Mappings({
                @Mapping(source = "idStudent", target = "idStudent"),
                @Mapping(source = "person", target = "person"),
                @Mapping(source = "numHoursWeek", target = "numHoursWeek"),
                @Mapping(source = "teacher", target = "teacher"),
                @Mapping(source = "branch", target = "branch")
        })
        StudentDetailsOutputDto toOutputDtoDetails(Student student);


        @Mappings({
                @Mapping(source = "idStudent", target = "idStudent"),
                @Mapping(source = "person", target = "person"),
                @Mapping(source = "numHoursWeek", target = "numHoursWeek"),
                @Mapping(source = "teacher", target = "teacher"),
                @Mapping(source = "branch", target = "branch")
        })
        List<StudentOutputDto> toOutputDtoList(List<Student> student);
}
