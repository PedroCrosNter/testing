package app.block5crudValidation.content.subject.domain.repository;

import app.block5crudValidation.content.subject.domain.entity.Subject;

import java.util.List;

public interface RetrieveSubjectRepository {

    Subject findById(Long idSubject);

    List<Subject> findAll();

    List<Subject> findByIdStudent(Long idStudent);
}
