package bridge.bms32back.domain.material;

import bridge.bms32back.business.material.MaterialDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MaterialMapper {
    @Mapping(source = "id" ,target = "materialId" )
    @Mapping(source = "name" ,target = "materialName" )
    MaterialDto toMaterialDto(Material material);

    List<MaterialDto> toMaterialDtos(List<Material>materials);
}