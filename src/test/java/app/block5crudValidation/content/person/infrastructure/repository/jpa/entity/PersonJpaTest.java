package app.block5crudValidation.content.person.infrastructure.repository.jpa.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PersonJpaTest {

    private PersonJpa personJpa;

    @BeforeEach
    void setUp() {
        personJpa = PersonJpa.builder()
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

    @Test
    void getIdPerson() {
        assertEquals(1L, personJpa.getIdPerson());
    }

    @Test
    void getUsername() {
        assertEquals("testUser", personJpa.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals("testPass", personJpa.getPassword());
    }

    @Test
    void getName() {
        assertEquals("John", personJpa.getName());
    }

    @Test
    void getSurname() {
        assertEquals("Doe", personJpa.getSurname());
    }

    @Test
    void getCompanyEmail() {
        assertEquals("john.doe@company.com", personJpa.getCompanyEmail());
    }

    @Test
    void getPersonalEmail() {
        assertEquals("john.doe@gmail.com", personJpa.getPersonalEmail());
    }

    @Test
    void getCity() {
        assertEquals("New York", personJpa.getCity());
    }

    @Test
    void getActive() {
        assertTrue(personJpa.getActive());
    }

    @Test
    void getCreatedDate() {
        assertEquals(LocalDate.of(2020, 1, 1), personJpa.getCreatedDate());
    }

    @Test
    void getImageUrl() {
        assertEquals("http://example.com/image.jpg", personJpa.getImageUrl());
    }

    @Test
    void getTerminationDate() {
        assertEquals(LocalDate.of(2021, 1, 1), personJpa.getTerminationDate());
    }

    @Test
    void setIdPerson() {
        personJpa.setIdPerson(2L);
        assertEquals(2L, personJpa.getIdPerson());
    }

    @Test
    void setUsername() {
        personJpa.setUsername("newUser");
        assertEquals("newUser", personJpa.getUsername());
    }

    @Test
    void setPassword() {
        personJpa.setPassword("newPass");
        assertEquals("newPass", personJpa.getPassword());
    }

    @Test
    void setName() {
        personJpa.setName("Jane");
        assertEquals("Jane", personJpa.getName());
    }

    @Test
    void setSurname() {
        personJpa.setSurname("Smith");
        assertEquals("Smith", personJpa.getSurname());
    }

    @Test
    void setCompanyEmail() {
        personJpa.setCompanyEmail("jane.smith@company.com");
        assertEquals("jane.smith@company.com", personJpa.getCompanyEmail());
    }

    @Test
    void setPersonalEmail() {
        personJpa.setPersonalEmail("jane.smith@gmail.com");
        assertEquals("jane.smith@gmail.com", personJpa.getPersonalEmail());
    }

    @Test
    void setCity() {
        personJpa.setCity("Los Angeles");
        assertEquals("Los Angeles", personJpa.getCity());
    }

    @Test
    void setActive() {
        personJpa.setActive(false);
        assertFalse(personJpa.getActive());
    }

    @Test
    void setCreatedDate() {
        LocalDate newDate = LocalDate.of(2022, 2, 2);
        personJpa.setCreatedDate(newDate);
        assertEquals(newDate, personJpa.getCreatedDate());
    }

    @Test
    void setImageUrl() {
        personJpa.setImageUrl("http://newexample.com/newimage.jpg");
        assertEquals("http://newexample.com/newimage.jpg", personJpa.getImageUrl());
    }

    @Test
    void setTerminationDate() {
        LocalDate newDate = LocalDate.of(2022, 2, 2);
        personJpa.setTerminationDate(newDate);
        assertEquals(newDate, personJpa.getTerminationDate());
    }

    @Test
    void builder() {
        PersonJpa newPerson = PersonJpa.builder()
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
