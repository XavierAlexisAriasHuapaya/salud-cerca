package digital.ah.salud_cerca.infrastructure.database.adapters;

import digital.ah.salud_cerca.domain.models.Person;
import digital.ah.salud_cerca.domain.repository.PersonRepository;
import digital.ah.salud_cerca.infrastructure.database.entities.PersonEntity;
import digital.ah.salud_cerca.infrastructure.database.repositories.JpaPersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@AllArgsConstructor
@Component
public class PersonMySQLAdapter implements PersonRepository {

    private final JpaPersonRepository jpaPersonRepository;

    @Override
    public Person save(Person person) {
        PersonEntity entity = new  PersonEntity();
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setDocumentTypeId(person.getDocumentType().getId());
        entity.setDocumentNumber(person.getDocumentNumber());
        entity.setPhone(person.getPhone());
        entity.setEmail(person.getEmail());
        entity.setBirthDate(person.getBirthDate());
        entity.setGenderId(person.getGender().getId());
        entity.setStatus(person.getStatus().name());
        entity.setCreatedAt(Instant.now());
        entity.setCreatedBy(1L);
        this.jpaPersonRepository.save(entity);
        return person;
    }

    @Override
    public Optional<Person> findByDocumentNumber(String documentNumber) {
        return Optional.empty();
    }
}
