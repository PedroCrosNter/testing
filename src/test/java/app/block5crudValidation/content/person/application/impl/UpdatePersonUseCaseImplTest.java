package app.block5crudValidation.content.person.application.impl;

import app.block5crudValidation.content.person.application.RetrievePersonUseCase;
import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.person.domain.repository.UpdatePersonRepository;
import app.block5crudValidation.shared.exceptions.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class UpdatePersonUseCaseImplTest {

    @Mock
    private UpdatePersonRepository updatePersonRepository;

    @Mock
    private RetrievePersonUseCase retrievePersonUseCase;

    private UpdatePersonUseCaseImpl updatePersonUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        updatePersonUseCase = new UpdatePersonUseCaseImpl(updatePersonRepository, retrievePersonUseCase);
    }

    @Test
    void update_ExistingPerson() throws EntityNotFoundException {
        Person person = new Person();
        person.setIdPerson(1L);

        when(retrievePersonUseCase.find(anyLong())).thenReturn(person);

        when(updatePersonRepository.update(person)).thenReturn(person);

        Long updatedPersonId = updatePersonUseCase.update(person);

        assertEquals(person.getIdPerson(), updatedPersonId);
        verify(retrievePersonUseCase).find(person.getIdPerson());
        verify(updatePersonRepository).update(person);
    }

    @Test
    void update_NonExistingPerson() {
        Person person = new Person();
        person.setIdPerson(1L);

        when(retrievePersonUseCase.find(anyLong())).thenThrow(new EntityNotFoundException(Person.class, person.getIdPerson()));

        assertThrows(EntityNotFoundException.class, () -> updatePersonUseCase.update(person));
        verify(retrievePersonUseCase).find(person.getIdPerson());
        verifyNoInteractions(updatePersonRepository);
    }
}
