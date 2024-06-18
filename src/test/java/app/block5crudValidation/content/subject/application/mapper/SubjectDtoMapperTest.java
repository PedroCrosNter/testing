package app.block5crudValidation.content.subject.application.mapper;

import app.block5crudValidation.content.subject.domain.entity.Subject;
import app.block5crudValidation.content.subject.infrastructure.controller.dto.input.SubjectCreateInputDto;
import app.block5crudValidation.content.subject.infrastructure.controller.dto.output.SubjectDetailsOutputDto;
import app.block5crudValidation.content.subject.infrastructure.controller.dto.output.SubjectOutputDto;
import app.block5crudValidation.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubjectDtoMapperTest {

    private final SubjectDtoMapper mapper = Mappers.getMapper(SubjectDtoMapper.class);

    @Test
    void toInputDto_fromSubject_shouldMapCorrectly() {
        // Given
        Subject subject = new Subject();
        subject.setIdSubject(1L);
        subject.setName("Math");

        // When
        SubjectCreateInputDto inputDto = mapper.toInputDto(subject);

        // Then
        assertNotNull(inputDto);
//        assertEquals(1L, inputDto.getIdStudent());
        assertEquals("Math", inputDto.getName());
    }

    @Test
    void toInputDto_fromSubjectJpa_shouldMapCorrectly() {
        // Given
        SubjectJpa subjectJpa = new SubjectJpa();
        subjectJpa.setIdSubject(1L);
        subjectJpa.setName("Math");

        // When
        SubjectCreateInputDto inputDto = mapper.toInputDto(subjectJpa);

        // Then
        assertNotNull(inputDto);
//        assertEquals(1L, inputDto.getIdStudent());
        assertEquals("Math", inputDto.getName());
    }

    @Test
    void toOutputDto_shouldMapCorrectly() {
        // Given
        Subject subject = new Subject();
        subject.setIdSubject(1L);
        subject.setName("Math");

        // When
        SubjectOutputDto outputDto = mapper.toOutputDto(subject);

        // Then
        assertNotNull(outputDto);
        assertEquals(1L, outputDto.getIdSubject());
        assertEquals("Math", outputDto.getName());
    }

    @Test
    void toOutputDtoDetails_shouldMapCorrectly() {
        // Given
        Subject subject = new Subject();
        subject.setIdSubject(1L);
        subject.setName("Math");

        // When
        SubjectDetailsOutputDto outputDto = mapper.toOutputDtoDetails(subject);

        // Then
        assertNotNull(outputDto);
        assertEquals(1L, outputDto.getIdSubject());
        assertEquals("Math", outputDto.getName());
    }

    @Test
    void toOutputDtoList_shouldMapCorrectly() {
        // Given
        List<Subject> subjects = new ArrayList<>();
        Subject subject1 = new Subject();
        subject1.setIdSubject(1L);
        subject1.setName("Math");
        subjects.add(subject1);

        // When
        List<SubjectOutputDto> outputDtoList = mapper.toOutputDtoList(subjects);

        // Then
        assertNotNull(outputDtoList);
        assertEquals(1, outputDtoList.size());
        assertEquals(1L, outputDtoList.get(0).getIdSubject());
        assertEquals("Math", outputDtoList.get(0).getName());
    }
}
