package app.block5crudValidation.content.person.domain.repository;

import app.block5crudValidation.content.person.domain.entity.Person;

import java.util.List;

public interface RetrievePersonRepository {

    Person find(Long idPerson);

    List<Person> findAll();
}
