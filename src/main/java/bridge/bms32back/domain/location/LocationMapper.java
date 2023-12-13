package bridge.bms32back.domain.location;

import bridge.bms32back.business.bridges.dto.BridgeAddDto;
import bridge.bms32back.business.location.LocationDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {

    @Mapping(source = "locationLongitude", target = "longitude")
    @Mapping(source = "locationLatitude", target = "latitude")
    Location toLocation(BridgeAddDto bridgeAddDto);
}