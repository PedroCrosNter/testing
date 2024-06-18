package app.block5crudValidation.content.person.application.impl;

import app.block5crudValidation.content.person.application.CreatePersonUseCase;
import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.person.domain.repository.CreatePersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePersonUseCaseImpl implements CreatePersonUseCase {

    private final CreatePersonRepository createPersonRepository;


    @Override
    public Long save(Person person) {

        return createPersonRepository.save(person);
    }
}
