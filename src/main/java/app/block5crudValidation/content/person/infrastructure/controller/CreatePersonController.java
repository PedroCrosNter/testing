package app.block5crudValidation.content.person.infrastructure.controller;

import app.block5crudValidation.content.person.application.CreatePersonUseCase;
import app.block5crudValidation.content.person.application.mapper.PersonEntityMapper;
import app.block5crudValidation.content.person.domain.entity.Person;
import app.block5crudValidation.content.person.infrastructure.controller.dto.input.PersonCreateInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/people")
public class CreatePersonController {

    private final CreatePersonUseCase createPersonUseCase;


    // POST: localhost:8080/people
    /**
     * BODY: {
     *     "username": "PEDROCROS", // length <= 10
     *     "password": "12345678900987654321",
     *     "name": "PEDRO",
     *     "surname": "CROS",
     *     "companyEmail": "pedro.cros@nter.es",
     *     "personalEmail": "pedro.cros@gmail.com",
     *     "city": "Jaén",
     *     "active": true,
     *     "createdDate": "2025-06-15T00:00:00Z",// "2024-05-25 17:10:00",
     *     "imageUrl": "http://example.com/pedro.cros.jpg",
     *     "terminationDate": "2025-06-15T00:00:00Z"
     * }
     */
    @PostMapping
    public ResponseEntity<Long> save(@RequestBody PersonCreateInputDto personCreateInputDto) {

        // Mapper FROM InputDto TO PersonJpa
        Person person = PersonEntityMapper.INSTANCE.toEntity(personCreateInputDto);

        // Applying use case
        Long personId = createPersonUseCase.save(person);

        // Build a ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(personId);
    }
}
