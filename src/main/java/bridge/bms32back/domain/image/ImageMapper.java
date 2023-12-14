package bridge.bms32back.domain.image;

import bridge.bms32back.business.image.ImageDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ImageMapper {
    @Mapping(source = "bridgeBridgeId", target = "bridge.bridgeId")
    Image toEntity(ImageDto imageDto);

    @Mapping(source = "bridge.bridgeId", target = "bridgeBridgeId")
    ImageDto toDto(Image image);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "bridgeBridgeId", target = "bridge.bridgeId")
    Image partialUpdate(ImageDto imageDto, @MappingTarget Image image);
}