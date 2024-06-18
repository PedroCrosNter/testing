package app.block5crudValidation.content.person.application;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.shared.exceptions.EntityNotFoundException;

import java.util.List;

public interface RetrievePersonUseCase {

    Person find(Long personId) throws EntityNotFoundException;

    List<Person> findAll();
}
