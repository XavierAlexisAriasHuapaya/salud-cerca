package digital.ah.salud_cerca.infrastructure.database.mappers;

import digital.ah.salud_cerca.domain.models.CatalogDetail;
import digital.ah.salud_cerca.infrastructure.database.entities.CatalogDetailEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CatalogDetailMapper {

    CatalogDetailMapper INSTANCE = Mappers.getMapper(CatalogDetailMapper.class);

    CatalogDetail toDomain(CatalogDetailEntity entity);

    @Mapping(target = "status", ignore = true)
    CatalogDetailEntity toEntity(CatalogDetail catalogDetail);

}
