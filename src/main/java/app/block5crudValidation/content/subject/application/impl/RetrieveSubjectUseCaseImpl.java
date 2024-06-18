package app.block5crudValidation.content.subject.application.impl;

import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import app.block5crudValidation.content.subject.application.RetrieveSubjectUseCase;
import app.block5crudValidation.content.subject.domain.entity.Subject;
import app.block5crudValidation.content.subject.domain.repository.RetrieveSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveSubjectUseCaseImpl implements RetrieveSubjectUseCase {

    private final RetrieveSubjectRepository retrieveSubjectRepository;


    @Override
    public Subject findById(Long idSubject) throws EntityNotFoundException {

        return retrieveSubjectRepository.findById(idSubject);
    }

    @Override
    public List<Subject> findAll() {

//        return retrieveSubjectRepository.findAll();

        List<Subject> subjectList = retrieveSubjectRepository.findAll();
        return subjectList;
    }

    @Override
    public List<Subject> findByIdStudent(Long idStudent) {

        return retrieveSubjectRepository.findByIdStudent(idStudent);
    }
}
