package app.block5crudValidation.content.person.infrastructure.controller;

import app.block5crudValidation.content.person.application.RetrievePersonUseCase;
import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.person.infrastructure.controller.dto.output.PersonOutputDto;
import app.block5crudValidation.utils.data.PersonDataTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class RetrievePersonControllerTest {

    @Mock
    private RetrievePersonUseCase retrievePersonUseCase;

    private RetrievePersonController retrievePersonController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        retrievePersonController = new RetrievePersonController(retrievePersonUseCase);
    }

    @Test
    void testFind() {
        // Arrange
        Long id = 1L;
        Person person = PersonDataTest.createTestPeople().getFirst(); // Here you should create a person with test data
        when(retrievePersonUseCase.find(id)).thenReturn(person);

        // Act
        ResponseEntity<PersonOutputDto> responseEntity = retrievePersonController.find(id);

        // Assert
        assertEquals(200, responseEntity.getStatusCodeValue());
        // Here you can add more assertions to verify that the returned data is as expected
    }

    @Test
    void testFindAll() {
        // Arrange
        List<Person> people = PersonDataTest.createTestPeople(); // Here you should create a list of persons with test data
        when(retrievePersonUseCase.findAll()).thenReturn(people);

        // Act
        ResponseEntity<List<PersonOutputDto>> responseEntity = retrievePersonController.findAll();

        // Assert
        assertEquals(200, responseEntity.getStatusCodeValue());
        // Here you can add more assertions to verify that the returned data is as expected
    }
}
