package bridge.bms32back.domain.location;

import bridge.bms32back.business.bridges.dto.BridgeRequestDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {

    @Mapping(source = "locationLongitude", target = "longitude")
    @Mapping(source = "locationLatitude", target = "latitude")
    Location toLocation(BridgeRequestDto bridgeRequestDto);
}