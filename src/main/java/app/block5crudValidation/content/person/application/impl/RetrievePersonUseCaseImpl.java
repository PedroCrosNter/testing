package app.block5crudValidation.content.person.application.impl;

import app.block5crudValidation.content.person.application.RetrievePersonUseCase;
import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.person.domain.repository.RetrievePersonRepository;
import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrievePersonUseCaseImpl implements RetrievePersonUseCase {

    private final RetrievePersonRepository retrievePersonRepository;


    @Override
    public Person find(Long idPerson) throws EntityNotFoundException {

        return retrievePersonRepository.find(idPerson);
    }

    @Override
    public List<Person> findAll() {

        return retrievePersonRepository.findAll();
    }
}