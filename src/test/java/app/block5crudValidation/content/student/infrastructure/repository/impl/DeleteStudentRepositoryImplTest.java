package app.block5crudValidation.content.student.infrastructure.repository.impl;

import app.block5crudValidation.content.student.domain.repository.DeleteStudentRepository;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.StudentRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class DeleteStudentRepositoryImplTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepositoryJpa studentRepositoryJpa;

    @Autowired
    private DeleteStudentRepository deleteStudentRepository;

//    @Test
//    void delete_ExistingStudent_ShouldDelete() {
//        // Given
//        StudentJpa student = new StudentJpa();
//        student.setNumHoursWeek(30);
//        entityManager.persist(student);
//        entityManager.flush();
//
//        // When
//        deleteStudentRepository.delete(student.getIdStudent());
//
//        // Then
//        assertFalse(studentRepositoryJpa.existsById(student.getIdStudent()));
//    }

//    @Test
//    void delete_NonExistingStudent_ShouldNotDelete() {
//        // Given
//        Long nonExistingId = 100L;
//
//        // When
//        deleteStudentRepository.delete(nonExistingId);
//
//        // Then
//        assertFalse(studentRepositoryJpa.existsById(nonExistingId));
//    }
}