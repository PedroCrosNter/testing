package app.block5crudValidation.content.person.infrastructure.controller;

import app.block5crudValidation.content.person.application.DeletePersonUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeletePersonControllerTest {

    @Test
    void delete_SuccessfulDeletion_ReturnsOk() {
        // Mock the DeletePersonUseCase
        DeletePersonUseCase deletePersonUseCase = Mockito.mock(DeletePersonUseCase.class);

        // Create an instance of the DeletePersonController with the mocked DeletePersonUseCase
        DeletePersonController deletePersonController = new DeletePersonController(deletePersonUseCase);

        // Define an ID for testing
        Long id = 1L;

        // Call the delete method
        ResponseEntity responseEntity = deletePersonController.delete(id);

        // Verify that the DeletePersonUseCase.delete method was called with the correct ID
        Mockito.verify(deletePersonUseCase, Mockito.times(1)).delete(id);

        // Verify that the response status is OK
        assertEquals(200, responseEntity.getStatusCodeValue());
    }
}
