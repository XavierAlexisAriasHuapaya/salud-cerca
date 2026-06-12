package digital.ah.salud_cerca.infrastructure.database.repositories;

import digital.ah.salud_cerca.infrastructure.database.entities.CatalogDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCatalogDetailRepository extends JpaRepository<CatalogDetailEntity, Long> {
}
