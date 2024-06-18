package app.block5crudValidation.content.student.application.impl;

import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.student.domain.repository.RetrieveStudentRepository;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import app.block5crudValidation.content.subject.application.RetrieveSubjectUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class RetrieveStudentUseCaseImplTest {

    @Mock
    private RetrieveStudentRepository retrieveStudentRepository;

    @Mock
    private RetrieveSubjectUseCase retrieveSubjectUseCase;

    @Mock
    private StudentRepositoryJpa studentRepositoryJpa;

    @InjectMocks
    private RetrieveStudentUseCaseImpl retrieveStudentUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void find_Success() {
        Long studentId = 1L;
        Student student = new Student();
        student.setIdStudent(studentId);

        when(retrieveStudentRepository.findById(studentId)).thenReturn(student);

        Student foundStudent = retrieveStudentUseCase.find(studentId);

        assertNotNull(foundStudent);
        assertEquals(studentId, foundStudent.getIdStudent());
        verify(retrieveStudentRepository, times(1)).findById(studentId);
    }

//    @Test
//    void find_StudentNotFound() {
//        Long studentId = 1L;
//
//        when(retrieveStudentRepository.findById(studentId));
//
//        assertThrows(EntityNotFoundException.class, () -> retrieveStudentUseCase.find(studentId));
//        verify(retrieveStudentRepository, times(1)).findById(studentId);
//    }

    @Test
    void findAll_Success() {
        List<Student> students = Arrays.asList(new Student(), new Student());

        when(retrieveStudentRepository.findAll()).thenReturn(students);

        List<Student> foundStudents = retrieveStudentUseCase.findAll();

        assertNotNull(foundStudents);
        assertEquals(2, foundStudents.size());
        verify(retrieveStudentRepository, times(1)).findAll();
    }

//    @Test
//    void findSubjectsByIdStudent_Success() {
//        Long studentId = 1L;
//        List<Subject> subjects = Arrays.asList(new Subject(), new Subject());
//
//        when(retrieveStudentRepository.findById(studentId)).thenReturn(retrieveStudentRepository.findById(studentId));
//        when(retrieveSubjectUseCase.findByIdStudent(studentId)).thenReturn(subjects);
//
//        List<Subject> foundSubjects = retrieveStudentUseCase.findSubjectsByIdStudent(studentId);
//
//        assertNotNull(foundSubjects);
//        assertEquals(2, foundSubjects.size());
//        verify(studentRepositoryJpa, times(1)).existsById(studentId);
//        verify(retrieveSubjectUseCase, times(1)).findByIdStudent(studentId);
//    }
}
