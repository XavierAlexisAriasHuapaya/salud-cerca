package digital.ah.salud_cerca.infrastructure.database.entities;

import digital.ah.salud_cerca.domain.models.CatalogHeader;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_catalog_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CatalogDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catalog_header_id", nullable = false)
    private CatalogHeaderEntity catalogHeader;

    private String description;

    @Column(nullable = false)
    private String status;

}
