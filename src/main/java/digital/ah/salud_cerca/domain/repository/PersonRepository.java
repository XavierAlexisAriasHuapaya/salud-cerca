package digital.ah.salud_cerca.domain.repository;

import digital.ah.salud_cerca.domain.models.Person;

import java.util.Optional;

public interface PersonRepository {

    Person save(Person person);

    Optional<Person> findByDocumentNumber(String documentNumber);

}
