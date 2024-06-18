package app.block5crudValidation.content.person.domain.repository;

import app.block5crudValidation.content.person.domain.entity.Person;

public interface CreatePersonRepository {

    Long save(Person person);
}
