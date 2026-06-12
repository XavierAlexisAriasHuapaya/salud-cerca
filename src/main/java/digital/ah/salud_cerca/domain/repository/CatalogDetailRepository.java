package digital.ah.salud_cerca.domain.repository;

import digital.ah.salud_cerca.domain.models.CatalogDetail;

public interface CatalogDetailRepository {

    CatalogDetail findById(Long id);

}
