package app.block5crudValidation.content.person.application;

public interface DeletePersonUseCase {

    void delete(Long idPerson);

    void delete(String idPerson);
}
