package bridge.bms32back.domain.type;

import bridge.bms32back.business.type.TypeDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TypeMapper {
    @Mapping(source = "id", target = "bridgeTypeId")
    @Mapping(source = "name", target = "bridgeType")
    TypeDto toTypeDto(Type type);

   List<TypeDto> toTypeDtos(List<Type> types);

}