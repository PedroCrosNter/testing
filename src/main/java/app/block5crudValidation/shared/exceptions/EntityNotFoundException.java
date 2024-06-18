package app.block5crudValidation.shared.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class<?> entityClass, Long id) {
        super("No " + entityClass.getSimpleName() + " found with ID: " + id);
    }
}
