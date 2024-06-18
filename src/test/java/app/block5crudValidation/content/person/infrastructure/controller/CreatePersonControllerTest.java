package app.block5crudValidation.content.person.infrastructure.controller;

import app.block5crudValidation.content.person.application.CreatePersonUseCase;
import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.person.infrastructure.controller.dto.input.PersonCreateInputDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CreatePersonControllerTest {

    @Test
    void save_ValidInput_ReturnsCreatedResponseWithPersonId() {
        // Mock CreatePersonUseCase
        CreatePersonUseCase createPersonUseCase = mock(CreatePersonUseCase.class);
        when(createPersonUseCase.save(any(Person.class))).thenReturn(123L);

        // Create controller instance with mocked use case
        CreatePersonController controller = new CreatePersonController(createPersonUseCase);

        // Create valid input DTO
        PersonCreateInputDto inputDto = new PersonCreateInputDto();
        inputDto.setUsername("testUser");
        // Populate other fields...

        // Call controller method
        ResponseEntity<Long> responseEntity = controller.save(inputDto);

        // Verify response
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(123L, responseEntity.getBody());
    }

}
