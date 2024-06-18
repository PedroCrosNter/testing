package app.block5crudValidation.content.person.infrastructure.controller.dto.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonCreateInputDtoTest {

    private PersonCreateInputDto dto;

    @BeforeEach
    void setUp() {
        dto = new PersonCreateInputDto();
    }

    @Test
    void getUsername() {
        String username = "testUser";
        dto.setUsername(username);
        assertEquals(username, dto.getUsername());
    }

    @Test
    void setUsername() {
        String username = "testUser";
        dto.setUsername(username);
        assertEquals(username, dto.getUsername());
    }

    @Test
    void getPassword() {
        String password = "password123";
        dto.setPassword(password);
        assertEquals(password, dto.getPassword());
    }

    @Test
    void setPassword() {
        String password = "password123";
        dto.setPassword(password);
        assertEquals(password, dto.getPassword());
    }

    @Test
    void getName() {
        String name = "John";
        dto.setName(name);
        assertEquals(name, dto.getName());
    }

    @Test
    void setName() {
        String name = "John";
        dto.setName(name);
        assertEquals(name, dto.getName());
    }

    @Test
    void getSurname() {
        String surname = "Doe";
        dto.setSurname(surname);
        assertEquals(surname, dto.getSurname());
    }

    @Test
    void setSurname() {
        String surname = "Doe";
        dto.setSurname(surname);
        assertEquals(surname, dto.getSurname());
    }

    @Test
    void getCompanyEmail() {
        String companyEmail = "john.doe@example.com";
        dto.setCompanyEmail(companyEmail);
        assertEquals(companyEmail, dto.getCompanyEmail());
    }

    @Test
    void setCompanyEmail() {
        String companyEmail = "john.doe@example.com";
        dto.setCompanyEmail(companyEmail);
        assertEquals(companyEmail, dto.getCompanyEmail());
    }

    @Test
    void getPersonalEmail() {
        String personalEmail = "john.doe@gmail.com";
        dto.setPersonalEmail(personalEmail);
        assertEquals(personalEmail, dto.getPersonalEmail());
    }

    @Test
    void setPersonalEmail() {
        String personalEmail = "john.doe@gmail.com";
        dto.setPersonalEmail(personalEmail);
        assertEquals(personalEmail, dto.getPersonalEmail());
    }

    @Test
    void getCity() {
        String city = "New York";
        dto.setCity(city);
        assertEquals(city, dto.getCity());
    }

    @Test
    void setCity() {
        String city = "New York";
        dto.setCity(city);
        assertEquals(city, dto.getCity());
    }

    @Test
    void getActive() {
        Boolean active = true;
        dto.setActive(active);
        assertEquals(active, dto.getActive());
    }

    @Test
    void setActive() {
        Boolean active = true;
        dto.setActive(active);
        assertEquals(active, dto.getActive());
    }

    @Test
    void getCreatedDate() {
        LocalDate createdDate = LocalDate.now();
        dto.setCreatedDate(createdDate);
        assertEquals(createdDate, dto.getCreatedDate());
    }

    @Test
    void setCreatedDate() {
        LocalDate createdDate = LocalDate.now();
        dto.setCreatedDate(createdDate);
        assertEquals(createdDate, dto.getCreatedDate());
    }

    @Test
    void getImageUrl() {
        String imageUrl = "http://example.com/image.jpg";
        dto.setImageUrl(imageUrl);
        assertEquals(imageUrl, dto.getImageUrl());
    }

    @Test
    void setImageUrl() {
        String imageUrl = "http://example.com/image.jpg";
        dto.setImageUrl(imageUrl);
        assertEquals(imageUrl, dto.getImageUrl());
    }

    @Test
    void getTerminationDate() {
        LocalDate terminationDate = LocalDate.of(2025, 12, 31);
        dto.setTerminationDate(terminationDate);
        assertEquals(terminationDate, dto.getTerminationDate());
    }

    @Test
    void setTerminationDate() {
        LocalDate terminationDate = LocalDate.of(2025, 12, 31);
        dto.setTerminationDate(terminationDate);
        assertEquals(terminationDate, dto.getTerminationDate());
    }
}
