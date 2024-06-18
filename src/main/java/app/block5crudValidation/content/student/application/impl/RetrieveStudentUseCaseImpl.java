package app.block5crudValidation.content.student.application.impl;

import app.block5crudValidation.content.student.application.RetrieveStudentUseCase;
import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.student.domain.repository.RetrieveStudentRepository;
import app.block5crudValidation.content.subject.application.RetrieveSubjectUseCase;
import app.block5crudValidation.content.subject.domain.entity.Subject;
import app.block5crudValidation.shared.enums.Branch;
import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RetrieveStudentUseCaseImpl implements RetrieveStudentUseCase {

    private final RetrieveStudentRepository retrieveStudentRepository;
    private final RetrieveSubjectUseCase retrieveSubjectUseCase;


    @Override
    public Student find(Long idStudent) throws EntityNotFoundException {

        return retrieveStudentRepository.findById(idStudent);
    }

        @Override
    public List<Student> findAll() {

//        return retrieveStudentRepository.findAll();

        List<Student> students = retrieveStudentRepository.findAll().stream()
                .peek(student -> {
                    if (student.getNumHoursWeek() == null) {
                        student.setNumHoursWeek(0);
                    }
                    if (student.getBranch() == null) {
                        student.setBranch(Branch.UNASSIGNED);
                    }
                })
                .collect(Collectors.toList());

            return students;
        }

    @Override
    public List<Subject> findSubjectsByIdStudent(Long idStudent) {
        return retrieveSubjectUseCase.findByIdStudent(idStudent);
    }
}
