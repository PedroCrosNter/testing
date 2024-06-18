package app.block5crudValidation.content.teacher.application.mapper;

import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.content.teacher.infrastructure.controller.dto.input.TeacherCreateInputDto;
import app.block5crudValidation.content.teacher.infrastructure.controller.dto.input.TeacherUpdateInputDto;
import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherEntityMapper {

    TeacherEntityMapper INSTANCE = Mappers.getMapper(TeacherEntityMapper.class);

    Teacher toEntity(TeacherCreateInputDto teacherCreateInputDto);

    Teacher toEntity(TeacherUpdateInputDto teacherUpdateInputDto);

    @Mapping(source = "personJpa", target = "person")
    Teacher toEntity(TeacherJpa teacherJpa);

    void toEntity(Teacher source, @MappingTarget TeacherJpa target);

    @Named("toEntityListFromJpa")
    List<Teacher> toEntityListFromJpa(List<TeacherJpa> teachers);

    @Named("toEntityListFromInputDto")
    List<Teacher> toEntityListFromInputDto(List<TeacherCreateInputDto> teacherInputDtoList);

    TeacherJpa toEntityJpa(Teacher teacher);

    List<TeacherJpa> toEntityJpaList(List<Teacher> teachers);

    Iterable<TeacherJpa> toEntityJpaIterable(List<Teacher> teachers);
}


//package app.block5crudValidation.content.teacher.application.mapper;
//
//import app.block5crudValidation.content.teacher.domain.entity.Teacher;
//import app.block5crudValidation.content.teacher.infrastructure.controller.dto.input.TeacherCreateInputDto;
//import app.block5crudValidation.content.teacher.infrastructure.controller.dto.input.TeacherUpdateInputDto;
//import app.block5crudValidation.content.teacher.infrastructure.repository.jpa.entity.TeacherJpa;
//import org.mapstruct.*;
//import org.mapstruct.factory.Mappers;
//
//import java.util.List;
//
//@Mapper(componentModel = "spring")//, uses = {PersonEntityMapper.class})
//public interface TeacherEntityMapper {
//
//    TeacherEntityMapper INSTANCE = Mappers.getMapper(TeacherEntityMapper.class);
//
//    Teacher toEntity(TeacherCreateInputDto teacherCreateInputDto);
//
//    Teacher toEntity(TeacherUpdateInputDto teacherUpdateInputDto);
//
//    @Mappings({
//            @Mapping(source = "personJpa", target = "person"),
//            @Mapping(source = "students", target = "students"),
//    })
//    Teacher toEntity(TeacherJpa teacherJpa);
//
//    void toEntity(Teacher source, @MappingTarget TeacherJpa target);
//
//    // ########################################## LIST #########################################
//    @Named("toEntityListFromJpa")
//    List<Teacher> toEntityListFromJpa(List<TeacherJpa> teachers);
//
//    @Named("toEntityListFromInputDto")
//    List<Teacher> toEntityListFromInputDto(List<TeacherCreateInputDto> teacherInputDtoList);
//
//
//    TeacherJpa toEntityJpa(Teacher teacher);
//
//    TeacherJpa toEntityJpa(TeacherJpa teacherJpa);
//
//    TeacherJpa toEntityJpa(TeacherCreateInputDto teacherCreateInputDto);
//
//    // ########################################## LIST #########################################
//    List<TeacherJpa> toEntityJpaList(List<Teacher> teachers);
//
//    Iterable<TeacherJpa> toEntityJpaIterable(List<Teacher> teachers);
//}
