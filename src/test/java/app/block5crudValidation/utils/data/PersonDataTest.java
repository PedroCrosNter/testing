package app.block5crudValidation.utils.data;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.person.infrastructure.repository.jpa.entity.PersonJpa;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class PersonDataTest {

    public static List<Person> createTestPeople() {
        // Creating test data for persons
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
        person2.setTerminationDate(null); // or set a specific termination date if needed

//        Person person3 = new Person();
//        person3.setIdPerson(null);
//        person3.setUsername(null);
//        person3.setPassword(null);
//        person3.setName(null);
//        person3.setSurname(null);
//        person3.setCompanyEmail(null);
//        person3.setPersonalEmail(null);
//        person3.setCity(null);
//        person3.setActive(null);
//        person3.setCreatedDate(null);
//        person3.setImageUrl(null);
//        person3.setTerminationDate(null);

        // Adding persons to the list
        return Arrays.asList(person1, person2/*, person3*/);
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
        person2.setTerminationDate(null); // or set a specific termination date if needed

//        PersonJpa person3 = new PersonJpa();
//        person3.setIdPerson(null);
//        person3.setUsername(null);
//        person3.setPassword(null);
//        person3.setName(null);
//        person3.setSurname(null);
//        person3.setCompanyEmail(null);
//        person3.setPersonalEmail(null);
//        person3.setCity(null);
//        person3.setActive(null);
//        person3.setCreatedDate(null);
//        person3.setImageUrl(null);
//        person3.setTerminationDate(null);

        // Adding persons to the list
        return Arrays.asList(person1, person2/*, person3*/);
    }
}