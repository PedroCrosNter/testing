package app.block5crudValidation.content.subject.infrastructure.repository.impl;

import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import app.block5crudValidation.content.student.application.RetrieveStudentUseCase;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import app.block5crudValidation.content.subject.application.mapper.SubjectEntityMapper;
import app.block5crudValidation.content.subject.domain.entity.Subject;
import app.block5crudValidation.content.subject.domain.repository.RetrieveSubjectRepository;
import app.block5crudValidation.content.subject.infrastructure.repository.jpa.SubjectRepositoryJpa;
import app.block5crudValidation.content.subject.infrastructure.repository.jpa.entity.SubjectJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RetrieveSubjectRepositoryImpl implements RetrieveSubjectRepository {

    private final SubjectRepositoryJpa subjectRepositoryJpa;
    private final StudentRepositoryJpa studentRepositoryJpa;


    @Override
    public Subject findById(Long idSubject) {

        return SubjectEntityMapper.INSTANCE.toEntity(
                subjectRepositoryJpa.findById(idSubject)
                        .orElseThrow(() -> new EntityNotFoundException(Subject.class, idSubject)));
    }

    @Override
    public List<Subject> findAll() {

        List<SubjectJpa> subjectJpaList = subjectRepositoryJpa.findAll();
        return subjectJpaList.stream()
                .map(SubjectEntityMapper.INSTANCE::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Subject> findByIdStudent(Long idStudent) {

        List<SubjectJpa> subjectJpaList = studentRepositoryJpa.findById(idStudent).get().getSubjects();

        List<Subject> subjectList = subjectJpaList.stream()
                .map(SubjectEntityMapper.INSTANCE::toEntity)
                .toList();

        return subjectList;
    }
}
