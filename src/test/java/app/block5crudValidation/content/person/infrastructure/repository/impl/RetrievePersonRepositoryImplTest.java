package app.block5crudValidation.content.person.infrastructure.repository.impl;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import app.block5crudValidation.content.person.infrastructure.repository.jpa.entity.PersonJpa;
import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class RetrievePersonRepositoryImplTest {

    @Mock
    private PersonRepositoryJpa personRepositoryJpa;

    @InjectMocks
    private RetrievePersonRepositoryImpl retrievePersonRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void find_existingPerson() {
        // Arrange
        Long idPerson = 1L;

        // Mocking behavior for personRepositoryJpa.findById()
        PersonJpa personJpa = new PersonJpa();
        personJpa.setIdPerson(idPerson);
        personJpa.setUsername("testuser");
        personJpa.setPassword("testpassword");
        personJpa.setName("Test");
        personJpa.setSurname("User");
        personJpa.setCompanyEmail("test@test.com");
        personJpa.setPersonalEmail("test@example.com");
        personJpa.setCity("Test City");
        personJpa.setActive(true);
        personJpa.setCreatedDate(LocalDate.now());
        personJpa.setImageUrl("test.jpg");
        personJpa.setTerminationDate(null);

        when(personRepositoryJpa.findById(idPerson)).thenReturn(Optional.of(personJpa));

        // Act
        Person foundPerson = retrievePersonRepository.find(idPerson);

        // Assert
        assertEquals(idPerson, foundPerson.getIdPerson());
        assertEquals(personJpa.getUsername(), foundPerson.getUsername());
        assertEquals(personJpa.getPassword(), foundPerson.getPassword());
        assertEquals(personJpa.getName(), foundPerson.getName());
        assertEquals(personJpa.getSurname(), foundPerson.getSurname());
        assertEquals(personJpa.getCompanyEmail(), foundPerson.getCompanyEmail());
        assertEquals(personJpa.getPersonalEmail(), foundPerson.getPersonalEmail());
        assertEquals(personJpa.getCity(), foundPerson.getCity());
        assertEquals(personJpa.getActive(), foundPerson.getActive());
        assertEquals(personJpa.getCreatedDate(), foundPerson.getCreatedDate());
        assertEquals(personJpa.getImageUrl(), foundPerson.getImageUrl());
        assertEquals(personJpa.getTerminationDate(), foundPerson.getTerminationDate());

        verify(personRepositoryJpa, times(1)).findById(idPerson);
    }

    @Test
    void find_personNotFound() {
        // Arrange
        Long idPerson = 2L;

        // Mocking behavior for personRepositoryJpa.findById() returning empty optional
        when(personRepositoryJpa.findById(idPerson)).thenReturn(Optional.empty());

        // Act and Assert
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            retrievePersonRepository.find(idPerson);
        });

        assertEquals("Person with id " + idPerson + " not found", "Person with id " + idPerson + " not found");

        verify(personRepositoryJpa, times(1)).findById(idPerson);
    }

    @Test
    void findAll() {
        // Arrange
        List<PersonJpa> personJpaList = new ArrayList<>();
        personJpaList.add(new PersonJpa(1L, "test1", "password1", "Test1", "User1", "test1@test.com",
                "test1@example.com", "City1", true, LocalDate.now(), "test1.jpg", null));
        personJpaList.add(new PersonJpa(2L, "test2", "password2", "Test2", "User2", "test2@test.com",
                "test2@example.com", "City2", false, LocalDate.now(), "test2.jpg", null));

        when(personRepositoryJpa.findAll()).thenReturn(personJpaList);

        // Act
        List<Person> foundPeople = retrievePersonRepository.findAll();

        // Assert
        assertEquals(personJpaList.size(), foundPeople.size());
        for (int i = 0; i < personJpaList.size(); i++) {
            assertEquals(personJpaList.get(i).getIdPerson(), foundPeople.get(i).getIdPerson());
            assertEquals(personJpaList.get(i).getUsername(), foundPeople.get(i).getUsername());
            assertEquals(personJpaList.get(i).getPassword(), foundPeople.get(i).getPassword());
            assertEquals(personJpaList.get(i).getName(), foundPeople.get(i).getName());
            assertEquals(personJpaList.get(i).getSurname(), foundPeople.get(i).getSurname());
            assertEquals(personJpaList.get(i).getCompanyEmail(), foundPeople.get(i).getCompanyEmail());
            assertEquals(personJpaList.get(i).getPersonalEmail(), foundPeople.get(i).getPersonalEmail());
            assertEquals(personJpaList.get(i).getCity(), foundPeople.get(i).getCity());
            assertEquals(personJpaList.get(i).getActive(), foundPeople.get(i).getActive());
            assertEquals(personJpaList.get(i).getCreatedDate(), foundPeople.get(i).getCreatedDate());
            assertEquals(personJpaList.get(i).getImageUrl(), foundPeople.get(i).getImageUrl());
            assertEquals(personJpaList.get(i).getTerminationDate(), foundPeople.get(i).getTerminationDate());
        }

        verify(personRepositoryJpa, times(1)).findAll();
    }
}
