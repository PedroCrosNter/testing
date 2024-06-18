package app.block5crudValidation.content.person.application;

import app.block5crudValidation.content.person.domain.entity.Person;

public interface CreatePersonUseCase {

    Long save(Person person);
}
