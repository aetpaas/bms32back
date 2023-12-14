package bridge.bms32back.business.bridges;

import bridge.bms32back.business.bridges.dto.*;
import bridge.bms32back.business.location.LocationsService;
import bridge.bms32back.domain.bridge.Bridge;
import bridge.bms32back.domain.bridge.BridgeMapper;
import bridge.bms32back.domain.bridge.BridgeService;
import bridge.bms32back.domain.county.County;
import bridge.bms32back.domain.county.CountyService;
import bridge.bms32back.domain.image.Image;
import bridge.bms32back.domain.image.ImageService;
import bridge.bms32back.domain.location.Location;
import bridge.bms32back.domain.location.LocationMapper;
import bridge.bms32back.domain.location.LocationService;
import bridge.bms32back.domain.material.Material;
import bridge.bms32back.domain.material.MaterialService;
import bridge.bms32back.domain.type.Type;
import bridge.bms32back.domain.type.TypeService;
import bridge.bms32back.infrastructure.ImageConverter;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BridgesService {

    @Resource
    private BridgeService bridgeService;
    @Resource
    private LocationsService locationsService;
    @Resource
    private LocationService locationService;
    @Resource
    private TypeService typeService;
    @Resource
    private MaterialService materialService;
    @Resource
    private ImageService imageService;
    @Resource
    private BridgeMapper bridgeMapper;
    @Resource
    private LocationMapper locationMapper;
    @Resource
    private CountyService countyService;


    public List<BridgeOverviewDto> findAllBridgesOverview() {
        List<Bridge> bridges = bridgeService.findAllBridges();
        List<BridgeOverviewDto> bridgeOverviewDtos = bridgeMapper.toBridgeOverviewDtos(bridges);
        return bridgeOverviewDtos;

    }

    public List<BridgeLocationInfoDto> findBridgeLocationInfosBy(BridgeSearchDto bridgeSearchDto) {
        handleBridgeWidthEndAdjustment(bridgeSearchDto);
        handleBridgeLengthEndAdjustment(bridgeSearchDto);
        handleConditionIndexEndAdjustment(bridgeSearchDto);

        List<Bridge> bridges = bridgeService.findBridgesBy(bridgeSearchDto);
        List<BridgeLocationInfoDto> bridgeLocationInfoDtos = bridgeMapper.toBridgeBasicInfoDtos(bridges);
        return bridgeLocationInfoDtos;
    }

    private static void handleBridgeWidthEndAdjustment(BridgeSearchDto bridgeSearchDto) {
        Integer bridgeWidthEnd = bridgeSearchDto.getBridgeWidthEnd();
        if (bridgeWidthEnd.equals(0)) {
            bridgeSearchDto.setBridgeWidthEnd(Integer.MAX_VALUE);
        }
    }

    private static void handleBridgeLengthEndAdjustment(BridgeSearchDto bridgeSearchDto) {
        Integer bridgeLengthEnd = bridgeSearchDto.getBridgeLengthEnd();
        if (bridgeLengthEnd.equals(0)) {
            bridgeSearchDto.setBridgeLengthEnd(Integer.MAX_VALUE);
        }
    }

    private static void handleConditionIndexEndAdjustment(BridgeSearchDto bridgeSearchDto) {
        Integer conditionIndexEnd = bridgeSearchDto.getConditionIndexEnd();
        if (conditionIndexEnd.equals(0)) {
            bridgeSearchDto.setConditionIndexEnd(Integer.MAX_VALUE);
        }
    }


    public List<BridgeLocationInfoDto> findAllBridgeLocationInfos() {
        List<Bridge> bridges = bridgeService.findAllBridges();
        List<BridgeLocationInfoDto> bridgeLocationInfoDtos = bridgeMapper.toBridgeBasicInfoDtos(bridges);
        return bridgeLocationInfoDtos;
    }

    @Transactional
    public void deleteBridgeInfo(Integer bridgeId) {
        Bridge bridge = bridgeService.getBridgeBy(bridgeId);
        Location location = bridge.getLocation();
        bridgeService.deleteBridge(bridge);
        locationService.deleteLocationBy(location);
    }

    public BridgeDetailsDto getBridgeBy(Integer bridgeId) {
        Bridge bridge = bridgeService.getBridgeBy(bridgeId);
        BridgeDetailsDto bridgeDetailsDto = bridgeMapper.toBridgeDetailedDto(bridge);
        return bridgeDetailsDto;
    }

    @Transactional
    public void addNewBridge(BridgeRequestDto bridgeRequestDto) {
        Type type = typeService.getTypeBy(bridgeRequestDto.getBridgeTypeId());
        Material material = materialService.getMaterialTypeBy(bridgeRequestDto.getMaterialId());
        Location location = createAndAddLocation(bridgeRequestDto);

        Bridge bridge = setBridgeTypeLocationAndMaterial(bridgeRequestDto, type, location, material);
        // see üleval asi teha meetodiks

        bridgeService.saveBridge(bridge);
        setCoverImageBridgeIdAndTypeAndSaveImage(bridgeRequestDto, bridge);


        String specialImageData = bridgeRequestDto.getSpecialImageData();
        if (imageDataExists(specialImageData)) {
            Image specialImage = ImageConverter.stringToImage(specialImageData);
            specialImage.setBridge(bridge);
            specialImage.setType("S");
            imageService.saveSpecialImage(specialImage);
        }

//        Image specialImage = ImageConverter.stringToImage((bridgeRequestDto.getSpecialImageData()));
//        if (specialImage == null) {
//
//        }
//


        //enne tuleb salvestada location, materjal, tüüp, alles siis sild.
        //lisada pildi salvestamine

    }

    private static boolean imageDataExists(String specialImageData) {
        return specialImageData != null && !specialImageData.isEmpty();
    }

    private void setCoverImageBridgeIdAndTypeAndSaveImage(BridgeRequestDto bridgeRequestDto, Bridge bridge) {
        Image coverImage = ImageConverter.stringToImage(bridgeRequestDto.getImageData());
        coverImage.setBridge(bridge);
        coverImage.setType("P");
        imageService.saveCoverImage(coverImage);
    }

    private Bridge setBridgeTypeLocationAndMaterial(BridgeRequestDto bridgeRequestDto, Type type, Location location, Material material) {
        Bridge bridge = bridgeMapper.toBridge(bridgeRequestDto);
        bridge.setType(type);
        bridge.setLocation(location);
        bridge.setMaterial(material);
        return bridge;
    }

    public Location createAndAddLocation(BridgeRequestDto bridgeRequestDto) {
        Location location = locationMapper.toLocation(bridgeRequestDto);
        County county = countyService.getCountyBy(bridgeRequestDto.getLocationCountyId());
        location.setCounty(county);
        return locationService.saveLocation(location);

    }
}
