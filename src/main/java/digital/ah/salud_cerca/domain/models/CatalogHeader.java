package digital.ah.salud_cerca.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatalogHeader {

    private Long id;

    private String description;

    public CatalogHeader(Long id, String description) {
        this.id = id;
        this.description = description;
    }
}
