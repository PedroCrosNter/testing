package app.block5crudValidation.content.person.infrastructure.repository.impl;

import app.block5crudValidation.content.person.application.mapper.PersonEntityMapper;
import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.person.domain.repository.CreatePersonRepository;
import app.block5crudValidation.content.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import app.block5crudValidation.content.person.infrastructure.repository.jpa.entity.PersonJpa;
import app.block5crudValidation.shared.exceptions.UnprocessableEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreatePersonRepositoryImpl implements CreatePersonRepository {

    private final PersonRepositoryJpa personRepositoryJpa;


    @Override
    public Long save(Person person) throws UnprocessableEntityException {

        if (person.getUsername().length() <= 6) {
            throw new UnprocessableEntityException("Username must be between 6 and 10 characters.");
        }
        if (person.getPassword().length() < 9) {
            throw new UnprocessableEntityException("Password must be minimum of 10 characters.");
        }

        PersonJpa personJpa = PersonEntityMapper.INSTANCE.toEntityJpa(person);

        return personRepositoryJpa.save(personJpa).getIdPerson();
    }
}
