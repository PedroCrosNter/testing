package app.block5crudValidation.content.person.domain.repository;

public interface DeletePersonRepository {

    Boolean delete(Long idPerson);

    void delete(String idPerson);
}