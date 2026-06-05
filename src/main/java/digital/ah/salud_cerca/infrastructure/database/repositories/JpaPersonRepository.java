package digital.ah.salud_cerca.infrastructure.database.repositories;

import digital.ah.salud_cerca.infrastructure.database.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaPersonRepository extends JpaRepository<PersonEntity, Long> {

    Optional<PersonEntity> findByDocumentNumber(String documentNumber);

}
