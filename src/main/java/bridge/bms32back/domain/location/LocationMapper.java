package bridge.bms32back.domain.location;

import bridge.bms32back.business.location.LocationDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {
    @Mapping(source = "countyName", target = "county.name")
    @Mapping(source = "countyId", target = "county.id")
    Location toEntity(LocationDto locationDto);

    @InheritInverseConfiguration(name = "toEntity")
    LocationDto toDto(Location location);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Location partialUpdate(LocationDto locationDto, @MappingTarget Location location);
}