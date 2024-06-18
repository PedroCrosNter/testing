package app.block5crudValidation.content.person.infrastructure.repository.impl;

import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.person.infrastructure.repository.jpa.PersonRepositoryJpa;
import app.block5crudValidation.shared.exceptions.UnprocessableEntityException;
import app.block5crudValidation.utils.data.PersonDataTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CreatePersonRepositoryImplTest {

    @Mock
    private PersonRepositoryJpa personRepositoryJpa;

    @InjectMocks
    private CreatePersonRepositoryImpl createPersonRepositoryImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void testSave_ValidPerson() {
//        // Crear una instancia de Person
//        Person person = PersonDataTest.createTestPeople().getFirst();
//
//        // Convertir la instancia de Person a PersonJpa
//        PersonJpa personJpa = PersonEntityMapper.INSTANCE.toEntityJpa(person);
//        // Establecer el idPerson en null para simular la creación de una nueva persona
//        personJpa.setIdPerson(null);
//
//        // Configurar Mockito para devolver personJpa cuando se llame al método save del repositorio personRepositoryJpa
//        when(personRepositoryJpa.save(any())).thenReturn(personJpa);
//
//        // Llamar al método save en CreatePersonRepositoryImpl y almacenar el resultado
//        Long result = createPersonRepositoryImpl.save(person);
//
//        // Verificar que el resultado no es nulo
//        assertNotNull(result);
//        // Verificar que el resultado es el esperado
//        assertEquals(1L, result);
//    }



    @Test
    public void testSave_InvalidUsername() {
        Person person = PersonDataTest.createTestPeople().getFirst();
        person.setUsername("short");

        assertThrows(UnprocessableEntityException.class, () -> {
            createPersonRepositoryImpl.save(person);
        });
    }

    @Test
    public void testSave_InvalidPassword() {
        Person person = PersonDataTest.createTestPeople().getFirst();
        person.setPassword("short");

        assertThrows(UnprocessableEntityException.class, () -> {
            createPersonRepositoryImpl.save(person);
        });
    }
}
