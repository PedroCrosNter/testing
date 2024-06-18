package app.block5crudValidation.utils.data;

import app.block5crudValidation.content.person.infrastructure.repository.jpa.entity.PersonJpa;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import app.block5crudValidation.content.subject.domain.entity.Subject;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class SubjectDataTest {

    public static List<Subject> createTestSubjects() {
        // Creating test data for subjects
        Subject subject1 = new Subject();
        subject1.setIdSubject(1L);
        subject1.setName("Mathematics");
        subject1.setComment("Basic mathematics course");
        subject1.setInitialDate(LocalDate.of(2021, 1, 1));
        subject1.setFinishDate(LocalDate.of(2021, 1, 31));

        Subject subject2 = new Subject();
        subject2.setIdSubject(2L);
        subject2.setName("Physics");
        subject2.setComment("Introductory physics course");
        subject2.setInitialDate(LocalDate.of(2021, 2, 1));
        subject2.setFinishDate(LocalDate.of(2021, 2, 28));

        // Adding subjects to the list
        return Arrays.asList(subject1, subject2);
    }

    public static List<PersonJpa> createTestPeopleJpa() {
        // Creating test data for persons
        PersonJpa person1 = new PersonJpa();
        person1.setIdPerson(1L);
        person1.setUsername("username1");
        person1.setPassword("password_1");
        person1.setName("John");
        person1.setSurname("Doe");
        person1.setCompanyEmail("john.doe@example.com");
        person1.setPersonalEmail("john@gmail.com");
        person1.setCity("New York");
        person1.setActive(true);
        person1.setCreatedDate(LocalDate.of(2021, 1, 1));
        person1.setImageUrl("http://example.com/john.jpg");
        person1.setTerminationDate(LocalDate.of(2021, 2, 1));

        PersonJpa person2 = new PersonJpa();
        person2.setIdPerson(2L);
        person2.setUsername("username2");
        person2.setPassword("password_2");
        person2.setName("Jane");
        person2.setSurname("Doe");
        person2.setCompanyEmail("jane.doe@example.com");
        person2.setPersonalEmail("jane@gmail.com");
        person2.setCity("Los Angeles");
        person2.setActive(true);
        person2.setCreatedDate(LocalDate.of(2021, 2, 15));
        person2.setImageUrl("http://example.com/jane.jpg");
        person2.setTerminationDate(null);

        // Adding persons to the list
        return Arrays.asList(person1, person2/*, person3*/);
    }

    public static List<StudentJpa> createTestStudentsJpa() {
        // Creating test data for students
        StudentJpa student1 = new StudentJpa();
        student1.setIdStudent(1L);
        student1.setPersonJpa(createTestPeopleJpa().get(0));
        student1.setNumHoursWeek(30);
        // Set other properties for student1

        StudentJpa student2 = new StudentJpa();
        student2.setIdStudent(2L);
        student2.setPersonJpa(createTestPeopleJpa().get(1));
        student2.setNumHoursWeek(20);
        // Set other properties for student2

        StudentJpa student3 = new StudentJpa();
        student3.setIdStudent(3L);
        student3.setPersonJpa(createTestPeopleJpa().get(0));
        student3.setNumHoursWeek(25);
        // Set other properties for student3

        // Adding students to the list
        return Arrays.asList(student1, student2, student3);
    }
}
