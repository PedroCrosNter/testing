package app.block5crudValidation.content.person.infrastructure.controller.dto.output;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonOutputDtoTest {

    @Test
    void gettersAndSettersTest() {
        // Create a PersonOutputDto instance
        PersonOutputDto personOutputDto = new PersonOutputDto();

        // Set values using setters
        personOutputDto.setIdPerson(1L);
        personOutputDto.setUsername("username");
        personOutputDto.setPassword("password");
        personOutputDto.setName("name");
        personOutputDto.setSurname("surname");
        personOutputDto.setCompanyEmail("company@example.com");
        personOutputDto.setPersonalEmail("personal@example.com");
        personOutputDto.setCity("city");
        personOutputDto.setActive(true);
        personOutputDto.setCreatedDate(LocalDate.now());
        personOutputDto.setImageUrl("image.jpg");
        personOutputDto.setTerminationDate(LocalDate.now());

        // Test getters
        assertEquals(1L, personOutputDto.getIdPerson());
        assertEquals("username", personOutputDto.getUsername());
        assertEquals("password", personOutputDto.getPassword());
        assertEquals("name", personOutputDto.getName());
        assertEquals("surname", personOutputDto.getSurname());
        assertEquals("company@example.com", personOutputDto.getCompanyEmail());
        assertEquals("personal@example.com", personOutputDto.getPersonalEmail());
        assertEquals("city", personOutputDto.getCity());
        assertTrue(personOutputDto.getActive());
        assertEquals(LocalDate.now(), personOutputDto.getCreatedDate());
        assertEquals("image.jpg", personOutputDto.getImageUrl());
        assertEquals(LocalDate.now(), personOutputDto.getTerminationDate());
    }

    @Test
    void builderTest() {
        // Create a PersonOutputDto instance using the builder
        PersonOutputDto personOutputDto = PersonOutputDto.builder()
                .idPerson(1L)
                .username("username")
                .password("password")
                .name("name")
                .surname("surname")
                .companyEmail("company@example.com")
                .personalEmail("personal@example.com")
                .city("city")
                .active(true)
                .createdDate(LocalDate.now())
                .imageUrl("image.jpg")
                .terminationDate(LocalDate.now())
                .build();

        // Test getters
        assertEquals(1L, personOutputDto.getIdPerson());
        assertEquals("username", personOutputDto.getUsername());
        assertEquals("password", personOutputDto.getPassword());
        assertEquals("name", personOutputDto.getName());
        assertEquals("surname", personOutputDto.getSurname());
        assertEquals("company@example.com", personOutputDto.getCompanyEmail());
        assertEquals("personal@example.com", personOutputDto.getPersonalEmail());
        assertEquals("city", personOutputDto.getCity());
        assertTrue(personOutputDto.getActive());
        assertEquals(LocalDate.now(), personOutputDto.getCreatedDate());
        assertEquals("image.jpg", personOutputDto.getImageUrl());
        assertEquals(LocalDate.now(), personOutputDto.getTerminationDate());
    }
}
