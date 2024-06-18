package app.block5crudValidation.utils.data;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.student.domain.entity.Student;
import app.block5crudValidation.content.student.infrastructure.repository.jpa.entity.StudentJpa;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.shared.enums.Branch;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class StudentDataTest {

    public static List<Student> createTestStudents() {
        // Creating test data for students
        Student student1 = new Student();
        student1.setIdStudent(1L);
        student1.setPerson(createTestPeople().get(0)); // Using test people data
        student1.setNumHoursWeek(20);
        student1.setTeacher(new Teacher()); // Dummy teacher data
        student1.setBranch(Branch.BACK);

        Student student2 = new Student();
        student2.setIdStudent(2L);
        student2.setPerson(createTestPeople().get(1)); // Using test people data
        student2.setNumHoursWeek(15);
        student2.setTeacher(new Teacher()); // Dummy teacher data
        student2.setBranch(Branch.FRONT);

        // Adding students to the list
        return Arrays.asList(student1, student2);
    }

    private static List<Person> createTestPeople() {
        // Mocking test people data for students
        Person person1 = new Person();
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

        Person person2 = new Person();
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
        return Arrays.asList(person1, person2);
    }

    public static List<StudentJpa> createTestStudentsJpa() {
        // Creating test data for students
        StudentJpa student1 = new StudentJpa();
        student1.setIdStudent(1L);
        // Set other properties for student1

        StudentJpa student2 = new StudentJpa();
        student2.setIdStudent(2L);
        // Set other properties for student2

        // Adding students to the list
        return Arrays.asList(student1, student2/*, student3*/);
    }
}
