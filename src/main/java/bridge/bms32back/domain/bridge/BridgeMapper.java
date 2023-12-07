package bridge.bms32back.domain.bridge;

import bridge.bms32back.business.bridges.dto.BridgeDto;
import bridge.bms32back.business.bridges.dto.BridgeSearchDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BridgeMapper {

    @Mapping(source = "id", target = "bridgeId")
    @Mapping(source = "number", target = "bridgeNumber")
    @Mapping(source = "name", target = "bridgeName")
    @Mapping(source = "length", target = "bridgeLength")
    @Mapping(source = "width", target = "bridgeWidth")
    @Mapping(source = "type.name", target = "bridgeType")
    @Mapping(source = "conditionIndex", target = "conditionIndex")
    @Mapping(source = "location.county.name", target = "locationCounty")
    @Mapping(source = "material.name", target = "bridgeMaterial")
    BridgeDto toBridgeDto(Bridge bridge);
    List<BridgeDto> toBridgeDtos(List<Bridge> bridges);



}