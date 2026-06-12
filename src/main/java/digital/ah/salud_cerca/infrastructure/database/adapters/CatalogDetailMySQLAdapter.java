package digital.ah.salud_cerca.infrastructure.database.adapters;

import digital.ah.salud_cerca.domain.models.CatalogDetail;
import digital.ah.salud_cerca.domain.repository.CatalogDetailRepository;
import digital.ah.salud_cerca.infrastructure.database.entities.CatalogDetailEntity;
import digital.ah.salud_cerca.infrastructure.database.exception.InfrastructureException;
import digital.ah.salud_cerca.infrastructure.database.mappers.CatalogDetailMapper;
import digital.ah.salud_cerca.infrastructure.database.repositories.JpaCatalogDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CatalogDetailMySQLAdapter implements CatalogDetailRepository {

    private final JpaCatalogDetailRepository repository;

    private final CatalogDetailMapper mapper;

    @Override
    public CatalogDetail findById(Long id) {
        CatalogDetailEntity entity = this.repository.findById(id).orElseThrow(
                () -> new InfrastructureException("Catalog Detailt with id " + id + " not found.")
        );
        return mapper.toDomain(entity);
    }
}
