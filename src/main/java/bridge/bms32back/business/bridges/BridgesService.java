package bridge.bms32back.business.bridges;

import bridge.bms32back.business.bridges.dto.*;
import bridge.bms32back.business.location.LocationsService;
import bridge.bms32back.domain.bridge.Bridge;
import bridge.bms32back.domain.bridge.BridgeMapper;
import bridge.bms32back.domain.bridge.BridgeService;
import bridge.bms32back.domain.location.Location;
import bridge.bms32back.domain.location.LocationRepository;
import bridge.bms32back.domain.location.LocationService;
import bridge.bms32back.domain.material.Material;
import bridge.bms32back.domain.material.MaterialService;
import bridge.bms32back.domain.type.Type;
import bridge.bms32back.domain.type.TypeService;
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
    private BridgeMapper bridgeMapper;
    private final LocationRepository locationRepository;

    public BridgesService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

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

    public void addNewBridge(BridgeAddDto bridgeAddDto) {
        Bridge bridge = bridgeMapper.toBridge(bridgeAddDto);
        Type type = typeService.getTypeBy(bridgeAddDto.getBridgeTypeId());
        bridge.setType(type);
        Location location = locationsService.addLocation(bridgeAddDto);
        bridge.setLocation(location);
        Material material = materialService.getMaterialTypeBy(bridgeAddDto.getMaterialId());
        bridge.setMaterial(material);
        bridgeService.saveNewBridge(bridge);


        // vaja minna locationService ja selle kaudu mappida location entity, kasutades koordinaate
        // siis tleb võtta county service caudu countyRepost countyId ning anda see edasi location entitile
        //tuua see location entity tagasi bridgesService teenusesse ning anda locationId bridge entitile
        //sama teha ka materjaliga

        //enne tuleb salvestada location, materjal, tüüp, alles siis sild.


    }
}
