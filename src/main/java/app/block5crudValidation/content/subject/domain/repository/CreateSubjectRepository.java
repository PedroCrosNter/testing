package app.block5crudValidation.content.subject.domain.repository;

import app.block5crudValidation.content.subject.domain.entity.Subject;

public interface CreateSubjectRepository {

    Long save(Subject subject);
}
