package app.block5crudValidation.content.student.application.impl;

import app.block5crudValidation.content.person.domain.repository.DeletePersonRepository;
import app.block5crudValidation.content.student.application.DeleteStudentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteStudentUseCaseImpl implements DeleteStudentUseCase {

    private final DeletePersonRepository deletePersonRepository;


    @Override
    public Boolean delete(Long idStudent) {
        return deletePersonRepository.delete(idStudent);
    }
}
