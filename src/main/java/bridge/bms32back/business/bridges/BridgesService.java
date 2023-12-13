package bridge.bms32back.business.bridges;

import bridge.bms32back.business.bridges.dto.BridgeLocationInfoDto;
import bridge.bms32back.business.bridges.dto.BridgeOverviewDto;
import bridge.bms32back.business.bridges.dto.BridgeSearchDto;
import bridge.bms32back.domain.bridge.Bridge;
import bridge.bms32back.domain.bridge.BridgeMapper;
import bridge.bms32back.domain.bridge.BridgeService;
import bridge.bms32back.domain.location.Location;
import bridge.bms32back.domain.location.LocationRepository;
import bridge.bms32back.domain.location.LocationService;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BridgesService {

    @Resource
    private BridgeService bridgeService;
    @Resource
    private LocationService locationService;
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
}
