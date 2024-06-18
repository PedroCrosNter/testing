package app.block5crudValidation.content.person.infrastructure.controller;

import app.block5crudValidation.content.person.application.RetrievePersonUseCase;
import app.block5crudValidation.content.person.application.mapper.PersonDtoMapper;
import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.person.infrastructure.controller.dto.output.PersonOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class RetrievePersonController {

    private final RetrievePersonUseCase retrievePersonUseCase;


    // GET: localhost:8080/people/{id}
    @GetMapping("/{idPerson}")
    public ResponseEntity<PersonOutputDto> find(@PathVariable Long idPerson) {

        Person person = retrievePersonUseCase.find(idPerson);

        return ResponseEntity
                .ok()
                .body(
                        PersonDtoMapper.INSTANCE.toOutputDto(person)
                );
    }

    // GET: localhost:8080/people
    @GetMapping
    public ResponseEntity<List<PersonOutputDto>> findAll() {

        List<Person> people = retrievePersonUseCase.findAll();

        List<PersonOutputDto> peopleOutputDto = PersonDtoMapper.INSTANCE.toOutputDtoList(people);

        return  ResponseEntity
                .ok()
                .body(
                        peopleOutputDto
                );
    }
}
