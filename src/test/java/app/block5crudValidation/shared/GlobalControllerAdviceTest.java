package app.block5crudValidation.shared;

import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import app.block5crudValidation.shared.exceptions.ForeignKeyException;
import app.block5crudValidation.shared.exceptions.UnprocessableEntityException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalControllerAdviceTest {

    private final GlobalControllerAdvice advice = new GlobalControllerAdvice();

    @Test
    void handleEntityNotFoundException() {
        EntityNotFoundException ex = new EntityNotFoundException(CustomError.class, 1L);
        ResponseEntity<CustomError> response = advice.handleEntityNotFoundException(ex);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        assertEquals("Entity not found", response.getBody().getMessage());
    }

    @Test
    void handleUnprocessableEntityException() {
        UnprocessableEntityException ex = new UnprocessableEntityException("Unprocessable entity");
        ResponseEntity<CustomError> response = advice.handleUnprocessableEntityException(ex);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
        assertEquals("Unprocessable entity", response.getBody().getMessage());
    }

    @Test
    void handleForeignKeyException() {
        ForeignKeyException ex = new ForeignKeyException(CustomError.class, 2L, Object.class, 3L);
        ResponseEntity<CustomError> response = advice.handleUnprocessableEntityException(ex);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
//        assertEquals("Foreign key constraint violation", response.getBody().getMessage());
    }
}
