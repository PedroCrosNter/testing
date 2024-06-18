package app.block5crudValidation.content.person.application.impl;

import app.block5crudValidation.content.person.application.RetrievePersonUseCase;
import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.person.domain.repository.RetrievePersonRepository;
import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RetrievePersonUseCaseImplTest {

    @Mock
    private RetrievePersonRepository retrievePersonRepository;

    private RetrievePersonUseCase retrievePersonUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        retrievePersonUseCase = new RetrievePersonUseCaseImpl(retrievePersonRepository);
    }

    @Test
    void findAll() {
        Person person1 = Person.builder().idPerson(1L).name("Person1").build();
        Person person2 = Person.builder().idPerson(2L).name("Person2").build();

        List<Person> persons = List.of(person1, person2);

        when(retrievePersonRepository.findAll()).thenReturn(persons);

        List<Person> foundPersons = retrievePersonUseCase.findAll();

        assertNotNull(foundPersons);
        assertEquals(2, foundPersons.size());
        assertEquals("Person1", foundPersons.get(0).getName());
        assertEquals("Person2", foundPersons.get(1).getName());

        verify(retrievePersonRepository, times(1)).findAll();
    }

    @Test
    void find() {
        Long idPerson = 1L;
        Person person = Person.builder().idPerson(idPerson).name("Person1").build();

        when(retrievePersonRepository.find(idPerson)).thenReturn(person);

        Person foundPerson = retrievePersonUseCase.find(idPerson);

        assertNotNull(foundPerson);
        assertEquals(idPerson, foundPerson.getIdPerson());
        assertEquals("Person1", foundPerson.getName());

        verify(retrievePersonRepository, times(1)).find(idPerson);
    }

    @Test
    void findNotFound() {
        Long idPerson = 1L;

        when(retrievePersonRepository.find(idPerson)).thenThrow(new EntityNotFoundException(Person.class, idPerson));

        assertThrows(EntityNotFoundException.class, () -> retrievePersonUseCase.find(idPerson));

        verify(retrievePersonRepository, times(1)).find(idPerson);
    }

    @Test
    void testFind() {
    }

    @Test
    void testFindAll() {
    }
}