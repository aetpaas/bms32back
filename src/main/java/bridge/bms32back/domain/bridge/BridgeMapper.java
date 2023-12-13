package bridge.bms32back.domain.bridge;

import bridge.bms32back.business.bridges.dto.BridgeLocationInfoDto;
import bridge.bms32back.business.bridges.dto.BridgeOverviewDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BridgeMapper {

    @Mapping(source = "bridgeId", target = "bridgeId")
    @Mapping(source = "number", target = "bridgeNumber")
    @Mapping(source = "name", target = "bridgeName")
    @Mapping(source = "length", target = "bridgeLength")
    @Mapping(source = "width", target = "bridgeWidth")
    @Mapping(source = "type.name", target = "bridgeType")
    @Mapping(source = "conditionIndex", target = "conditionIndex")
    @Mapping(source = "location.county.name", target = "locationCounty")
    @Mapping(source = "material.name", target = "bridgeMaterial")
    BridgeOverviewDto toBridgeOverviewDto(Bridge bridge);
    List<BridgeOverviewDto> toBridgeOverviewDtos(List<Bridge> bridges);


    @Mapping(source = "bridgeId", target = "bridgeId")
    @Mapping(source = "name", target = "bridgeName")
    @Mapping(source = "location.latitude", target = "position.lat")
    @Mapping(source = "location.longitude", target = "position.lng")
    BridgeLocationInfoDto toBridgeBasicInfoDto(Bridge bridge);

    List<BridgeLocationInfoDto> toBridgeBasicInfoDtos(List<Bridge> bridges);
}