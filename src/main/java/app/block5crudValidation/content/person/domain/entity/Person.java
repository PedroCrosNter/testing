package app.block5crudValidation.content.person.domain.entity;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Person {

    private Long idPerson;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private Boolean active;
    private LocalDate createdDate;
    private String imageUrl;
    private LocalDate terminationDate;
}
