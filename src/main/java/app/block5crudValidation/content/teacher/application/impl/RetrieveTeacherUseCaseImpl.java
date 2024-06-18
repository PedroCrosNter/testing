package app.block5crudValidation.content.teacher.application.impl;

import app.block5crudValidation.content.teacher.application.RetrieveTeacherUseCase;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.content.teacher.domain.repository.RetrieveTeacherRepository;
import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveTeacherUseCaseImpl implements RetrieveTeacherUseCase {

    private final RetrieveTeacherRepository retrieveTeacherRepository;


    @Override
    public Teacher find(Long idTeacher) throws EntityNotFoundException {

        Teacher teacher;

        try {
            teacher = retrieveTeacherRepository.find(idTeacher);
        } catch (Exception e) {
            throw new EntityNotFoundException(Teacher.class, idTeacher);
        }

        return teacher;
    }

    @Override
    public List<Teacher> findAll() {
        return retrieveTeacherRepository.findAll();
    }
}
