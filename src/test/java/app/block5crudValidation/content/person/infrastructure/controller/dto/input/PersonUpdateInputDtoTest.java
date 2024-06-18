package app.block5crudValidation.content.person.infrastructure.controller.dto.input;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonUpdateInputDtoTest {

    @Test
    void testGetIdPerson() {
        Long idPerson = 1L;
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setIdPerson(idPerson);
        assertEquals(idPerson, dto.getIdPerson());
    }

    @Test
    void testGetUsername() {
        String username = "john_doe";
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setUsername(username);
        assertEquals(username, dto.getUsername());
    }

    @Test
    void testGetPassword() {
        String password = "password123";
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setPassword(password);
        assertEquals(password, dto.getPassword());
    }

    @Test
    void testGetName() {
        String name = "John";
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setName(name);
        assertEquals(name, dto.getName());
    }

    @Test
    void testGetSurname() {
        String surname = "Doe";
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setSurname(surname);
        assertEquals(surname, dto.getSurname());
    }

    @Test
    void testGetCompanyEmail() {
        String companyEmail = "john@example.com";
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setCompanyEmail(companyEmail);
        assertEquals(companyEmail, dto.getCompanyEmail());
    }

    @Test
    void testGetPersonalEmail() {
        String personalEmail = "john.doe@gmail.com";
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setPersonalEmail(personalEmail);
        assertEquals(personalEmail, dto.getPersonalEmail());
    }

    @Test
    void testGetCity() {
        String city = "New York";
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setCity(city);
        assertEquals(city, dto.getCity());
    }

    @Test
    void testGetActive() {
        Boolean active = true;
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setActive(active);
        assertEquals(active, dto.getActive());
    }

    @Test
    void testGetCreatedDate() {
        LocalDate createdDate = LocalDate.now();
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setCreatedDate(createdDate);
        assertEquals(createdDate, dto.getCreatedDate());
    }

    @Test
    void testGetImageUrl() {
        String imageUrl = "http://example.com/image.jpg";
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setImageUrl(imageUrl);
        assertEquals(imageUrl, dto.getImageUrl());
    }

    @Test
    void testGetTerminationDate() {
        LocalDate terminationDate = LocalDate.now().plusDays(7);
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setTerminationDate(terminationDate);
        assertEquals(terminationDate, dto.getTerminationDate());
    }

    @Test
    void testSetIdPerson() {
        Long idPerson = 1L;
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setIdPerson(idPerson);
        assertEquals(idPerson, dto.getIdPerson());
    }

    @Test
    void testSetUsername() {
        String username = "john_doe";
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setUsername(username);
        assertEquals(username, dto.getUsername());
    }

    @Test
    void testSetPassword() {
        String password = "password123";
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setPassword(password);
        assertEquals(password, dto.getPassword());
    }

    @Test
    void testSetName() {
        String name = "John";
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setName(name);
        assertEquals(name, dto.getName());
    }

    @Test
    void testSetSurname() {
        String surname = "Doe";
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setSurname(surname);
        assertEquals(surname, dto.getSurname());
    }

    @Test
    void testSetCompanyEmail() {
        String companyEmail = "john@example.com";
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setCompanyEmail(companyEmail);
        assertEquals(companyEmail, dto.getCompanyEmail());
    }

    @Test
    void testSetPersonalEmail() {
        String personalEmail = "john.doe@gmail.com";
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setPersonalEmail(personalEmail);
        assertEquals(personalEmail, dto.getPersonalEmail());
    }

    @Test
    void testSetCity() {
        String city = "New York";
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setCity(city);
        assertEquals(city, dto.getCity());
    }

    @Test
    void testSetActive() {
        Boolean active = true;
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setActive(active);
        assertEquals(active, dto.getActive());
    }

    @Test
    void testSetCreatedDate() {
        LocalDate createdDate = LocalDate.now();
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setCreatedDate(createdDate);
        assertEquals(createdDate, dto.getCreatedDate());
    }

    @Test
    void testSetImageUrl() {
        String imageUrl = "http://example.com/image.jpg";
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setImageUrl(imageUrl);
        assertEquals(imageUrl, dto.getImageUrl());
    }

    @Test
    void testSetTerminationDate() {
        LocalDate terminationDate = LocalDate.now().plusDays(7);
        PersonUpdateInputDto dto = new PersonUpdateInputDto();
        dto.setTerminationDate(terminationDate);
        assertEquals(terminationDate, dto.getTerminationDate());
    }
}
