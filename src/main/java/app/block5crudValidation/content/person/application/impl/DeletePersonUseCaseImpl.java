package app.block5crudValidation.content.person.application.impl;

import app.block5crudValidation.content.person.application.DeletePersonUseCase;
import app.block5crudValidation.content.person.domain.repository.DeletePersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePersonUseCaseImpl implements DeletePersonUseCase {

    private final DeletePersonRepository deletePersonRepository;


    @Override
    public void delete(Long idPerson) {
        deletePersonRepository.delete(idPerson);
    }

    @Override
    public void delete(String idPerson) {
        this.delete(Long.valueOf(idPerson));
    }
}
