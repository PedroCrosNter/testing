package app.block5crudValidation.content.subject.infrastructure.controller;

import app.block5crudValidation.content.subject.application.CreateSubjectUseCase;
import app.block5crudValidation.content.subject.application.mapper.SubjectEntityMapper;
import app.block5crudValidation.content.subject.domain.entity.Subject;
import app.block5crudValidation.content.subject.infrastructure.controller.dto.input.SubjectCreateInputDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CreateSubjectControllerTest {

    @Mock
    private CreateSubjectUseCase createSubjectUseCase;

    @InjectMocks
    private CreateSubjectController createSubjectController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() {
        // Datos de prueba
        SubjectCreateInputDto inputDto = new SubjectCreateInputDto();
        inputDto.setIdStudent(1L);
        inputDto.setName("Programming");

        Subject subject = SubjectEntityMapper.INSTANCE.toEntity(inputDto);
        Long expectedId = 1L;

        // Configuración del mock
        when(createSubjectUseCase.save(any(Subject.class))).thenReturn(expectedId);

        // Llamada al método del controlador
        ResponseEntity<Long> responseEntity = createSubjectController.save(inputDto);

        // Verificaciones
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(expectedId, responseEntity.getBody());
    }
}
