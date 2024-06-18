package app.block5crudValidation.content.person.application;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.shared.exceptions.EntityNotFoundException;

public interface UpdatePersonUseCase {

    Long update(Person person) throws EntityNotFoundException;
}
