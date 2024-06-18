package app.block5crudValidation.content.subject.application;

import app.block5crudValidation.content.subject.domain.entity.Subject;

public interface CreateSubjectUseCase {

    Long save(Subject subject);
}
