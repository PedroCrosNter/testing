package app.block5crudValidation.content.teacher.application.impl;

import app.block5crudValidation.content.person.application.RetrievePersonUseCase;
import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.teacher.application.mapper.TeacherEntityMapper;
import app.block5crudValidation.content.teacher.domain.entity.Teacher;
import app.block5crudValidation.content.teacher.domain.repository.CreateTeacherRepository;
import app.block5crudValidation.content.teacher.infrastructure.controller.dto.input.TeacherCreateInputDto;
import app.block5crudValidation.shared.enums.Branch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class CreateTeacherUseCaseImplTest {

    @Mock
    private CreateTeacherRepository createTeacherRepository;

    @Mock
    private RetrievePersonUseCase retrievePersonUseCase;

    @InjectMocks
    private CreateTeacherUseCaseImpl createTeacherUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() {
        // Arrange
        TeacherCreateInputDto inputDto = new TeacherCreateInputDto();
        inputDto.setIdPerson(1L);
        inputDto.setComments("Excellent teacher");
        inputDto.setBranch(Branch.BACK);

        Person person = new Person();
        person.setIdPerson(1L);
        // Assuming other necessary properties are set for person

        Teacher teacher = TeacherEntityMapper.INSTANCE.toEntity(inputDto);
        teacher.setPerson(person);

        when(retrievePersonUseCase.find(anyLong())).thenReturn(person);
        when(createTeacherRepository.save(any(Teacher.class))).thenReturn(1L);

        // Act
        Long savedTeacherId = createTeacherUseCase.save(inputDto);

        // Assert
        assertEquals(1L, savedTeacherId);

        // Verify interactions
        verify(retrievePersonUseCase, times(1)).find(inputDto.getIdPerson());
//        verify(createTeacherRepository, times(1)).save(teacher);
    }
}
