package app.block5crudValidation.content.subject.application.impl;

import app.block5crudValidation.content.subject.application.DeleteSubjectUseCase;
import app.block5crudValidation.content.subject.domain.repository.DeleteSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteSubjectUseCaseImpl implements DeleteSubjectUseCase {

    private final DeleteSubjectRepository deleteSubjectRepository;


    @Override
    public Boolean delete(Long idSubject) {

        return deleteSubjectRepository.delete(idSubject);
    }
}
