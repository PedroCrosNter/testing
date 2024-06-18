package app.block5crudValidation.content.subject.application.impl;

import app.block5crudValidation.content.subject.application.CreateSubjectUseCase;
import app.block5crudValidation.content.subject.domain.entity.Subject;
import app.block5crudValidation.content.subject.domain.repository.CreateSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSubjectUseCaseImpl implements CreateSubjectUseCase {

    private final CreateSubjectRepository createSubjectRepository;


    @Override
    public Long save(Subject subject) {

        return createSubjectRepository.save(subject);
    }
}
