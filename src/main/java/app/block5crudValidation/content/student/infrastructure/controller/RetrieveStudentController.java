package app.block5crudValidation.content.student.infrastructure.controller;

import app.block5crudValidation.content.student.application.RetrieveStudentUseCase;
import app.block5crudValidation.content.student.application.mapper.StudentDtoMapper;
import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.student.infrastructure.controller.dto.output.StudentOutputDto;
import app.block5crudValidation.content.subject.application.mapper.SubjectDtoMapper;
import app.block5crudValidation.content.subject.domain.entity.Subject;
import app.block5crudValidation.content.subject.infrastructure.controller.dto.output.SubjectOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class RetrieveStudentController {

    private final RetrieveStudentUseCase retrieveStudentUseCase;


    // GET: localhost:8080/students/{idStudent}
    @GetMapping("/{idStudent}")
    public ResponseEntity findById(
            @PathVariable Long idStudent
            ,@RequestParam(value = "outerType", required = false, defaultValue = "simple") String outerType
    ) {

        Student student = retrieveStudentUseCase.find(idStudent);

        Object output;

        if ("full".equalsIgnoreCase(outerType)) {
            output = StudentDtoMapper.INSTANCE.toOutputDtoDetails(student);
        } else {
            output = StudentDtoMapper.INSTANCE.toOutputDto(student);
        }


        return ResponseEntity
                .ok()
                .body(
                        output
                );
    }

    // GET: localhost:8080/students
    @GetMapping
    public ResponseEntity<List<StudentOutputDto>> findAll() {

        List<Student> students = retrieveStudentUseCase.findAll();

        List<StudentOutputDto> studentOutputDtoList = StudentDtoMapper.INSTANCE.toOutputDtoList(students);

        return  ResponseEntity
                .ok()
                .body(
                        studentOutputDtoList
                );
    }

    // GET: localhost:8080/students/{idStudent}
    @GetMapping("/{idStudent}/subjects")
    public ResponseEntity<List<SubjectOutputDto>> findSubjectsByIdStudent(
            @PathVariable Long idStudent
    ) {

        List<Subject> subjectList = retrieveStudentUseCase.findSubjectsByIdStudent(idStudent);

        List<SubjectOutputDto> subjectOutputDtoList = SubjectDtoMapper.INSTANCE.toOutputDtoList(subjectList);

        return ResponseEntity
                .ok()
                .body(
                        subjectOutputDtoList
                );
    }
}
