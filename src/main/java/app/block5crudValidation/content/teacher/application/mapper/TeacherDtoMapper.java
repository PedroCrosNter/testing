package app.block5crudValidation.content.teacher.application.mapper;

import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.content.teacher.infrastructure.controller.dto.input.TeacherCreateInputDto;
import app.block5crudValidation.content.teacher.infrastructure.controller.dto.output.TeacherDetailsOutputDto;
import app.block5crudValidation.content.teacher.infrastructure.controller.dto.output.TeacherOutputDto;
import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherDtoMapper {

    TeacherDtoMapper INSTANCE = Mappers.getMapper(TeacherDtoMapper.class);


    TeacherCreateInputDto toInputDto(Teacher teacher);

    TeacherCreateInputDto toInputDto(TeacherJpa teacherJpa);


    TeacherOutputDto toOutputDto(Teacher teacher);

    @Mapping(source = "students", target = "students")
    TeacherDetailsOutputDto toOutputDtoDetails(Teacher teacher);

    TeacherOutputDto toOutputDto(TeacherJpa teacherJpa);


    @Mappings({
            @Mapping(source = "idStudent", target = "idStudent"),
            @Mapping(source = "comments", target = "comments"),
            @Mapping(source = "person", target = "person"),
            @Mapping(source = "numHoursWeek", target = "numHoursWeek"),
            @Mapping(source = "teacher", target = "teacher"),
            @Mapping(source = "branch", target = "branch"),
    })
    List<TeacherOutputDto> toOutputDtoList(List<Teacher> teacher);
}
