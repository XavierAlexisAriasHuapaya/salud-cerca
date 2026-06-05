package digital.ah.salud_cerca.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatalogDetail {

    private Long id;

    private CatalogHeader catalogHeader;

    private String description;

    public CatalogDetail(Long id, CatalogHeader catalogHeader, String description) {
        this.id = id;
        this.catalogHeader = catalogHeader;
        this.description = description;
    }
}
