package app.block5crudValidation.content.person.domain.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = Person.builder()
                .idPerson(1L)
                .username("testUser")
                .password("testPass")
                .name("John")
                .surname("Doe")
                .companyEmail("john.doe@company.com")
                .personalEmail("john.doe@gmail.com")
                .city("New York")
                .active(true)
                .createdDate(LocalDate.of(2020, 1, 1))
                .imageUrl("http://example.com/image.jpg")
                .terminationDate(LocalDate.of(2021, 1, 1))
                .build();
    }

    @AfterEach
    void tearDown() {
        person = null;
    }

    @Test
    void getIdPerson() {
        assertEquals(1L, person.getIdPerson());
    }

    @Test
    void getUsername() {
        assertEquals("testUser", person.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals("testPass", person.getPassword());
    }

    @Test
    void getName() {
        assertEquals("John", person.getName());
    }

    @Test
    void getSurname() {
        assertEquals("Doe", person.getSurname());
    }

    @Test
    void getCompanyEmail() {
        assertEquals("john.doe@company.com", person.getCompanyEmail());
    }

    @Test
    void getPersonalEmail() {
        assertEquals("john.doe@gmail.com", person.getPersonalEmail());
    }

    @Test
    void getCity() {
        assertEquals("New York", person.getCity());
    }

    @Test
    void getActive() {
        assertTrue(person.getActive());
    }

    @Test
    void getCreatedDate() {
        assertEquals(LocalDate.of(2020, 1, 1), person.getCreatedDate());
    }

    @Test
    void getImageUrl() {
        assertEquals("http://example.com/image.jpg", person.getImageUrl());
    }

    @Test
    void getTerminationDate() {
        assertEquals(LocalDate.of(2021, 1, 1), person.getTerminationDate());
    }

    @Test
    void setIdPerson() {
        person.setIdPerson(2L);
        assertEquals(2L, person.getIdPerson());
    }

    @Test
    void setUsername() {
        person.setUsername("newUser");
        assertEquals("newUser", person.getUsername());
    }

    @Test
    void setPassword() {
        person.setPassword("newPass");
        assertEquals("newPass", person.getPassword());
    }

    @Test
    void setName() {
        person.setName("Jane");
        assertEquals("Jane", person.getName());
    }

    @Test
    void setSurname() {
        person.setSurname("Smith");
        assertEquals("Smith", person.getSurname());
    }

    @Test
    void setCompanyEmail() {
        person.setCompanyEmail("jane.smith@company.com");
        assertEquals("jane.smith@company.com", person.getCompanyEmail());
    }

    @Test
    void setPersonalEmail() {
        person.setPersonalEmail("jane.smith@gmail.com");
        assertEquals("jane.smith@gmail.com", person.getPersonalEmail());
    }

    @Test
    void setCity() {
        person.setCity("Los Angeles");
        assertEquals("Los Angeles", person.getCity());
    }

    @Test
    void setActive() {
        person.setActive(false);
        assertFalse(person.getActive());
    }

    @Test
    void setCreatedDate() {
        LocalDate newDate = LocalDate.of(2022, 2, 2);
        person.setCreatedDate(newDate);
        assertEquals(newDate, person.getCreatedDate());
    }

    @Test
    void setImageUrl() {
        person.setImageUrl("http://newexample.com/newimage.jpg");
        assertEquals("http://newexample.com/newimage.jpg", person.getImageUrl());
    }

    @Test
    void setTerminationDate() {
        LocalDate newDate = LocalDate.of(2022, 2, 2);
        person.setTerminationDate(newDate);
        assertEquals(newDate, person.getTerminationDate());
    }

    @Test
    void builder() {
        Person newPerson = Person.builder()
                .idPerson(2L)
                .username("newUser")
                .password("newPass")
                .name("Jane")
                .surname("Smith")
                .companyEmail("jane.smith@company.com")
                .personalEmail("jane.smith@gmail.com")
                .city("Los Angeles")
                .active(false)
                .createdDate(LocalDate.of(2022, 2, 2))
                .imageUrl("http://newexample.com/newimage.jpg")
                .terminationDate(LocalDate.of(2023, 3, 3))
                .build();

        assertNotNull(newPerson);
        assertEquals(2L, newPerson.getIdPerson());
        assertEquals("newUser", newPerson.getUsername());
        assertEquals("newPass", newPerson.getPassword());
        assertEquals("Jane", newPerson.getName());
        assertEquals("Smith", newPerson.getSurname());
        assertEquals("jane.smith@company.com", newPerson.getCompanyEmail());
        assertEquals("jane.smith@gmail.com", newPerson.getPersonalEmail());
        assertEquals("Los Angeles", newPerson.getCity());
        assertFalse(newPerson.getActive());
        assertEquals(LocalDate.of(2022, 2, 2), newPerson.getCreatedDate());
        assertEquals("http://newexample.com/newimage.jpg", newPerson.getImageUrl());
        assertEquals(LocalDate.of(2023, 3, 3), newPerson.getTerminationDate());
    }
}
