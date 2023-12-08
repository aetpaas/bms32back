package bridge.bms32back.business.bridges;

import bridge.bms32back.business.bridges.dto.BridgeLocationInfoDto;
import bridge.bms32back.business.bridges.dto.BridgeOverviewDto;
import bridge.bms32back.business.bridges.dto.BridgeSearchDto;
import bridge.bms32back.domain.bridge.Bridge;
import bridge.bms32back.domain.bridge.BridgeMapper;
import bridge.bms32back.domain.bridge.BridgeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BridgesService {

    @Resource
    private BridgeService bridgeService;
    @Resource
    private BridgeMapper bridgeMapper;

    public List<BridgeOverviewDto> findAllBridgesOverview() {
        List<Bridge> bridges = bridgeService.findAllBridges();
        List<BridgeOverviewDto> bridgeOverviewDtos = bridgeMapper.toBridgeOverviewDtos(bridges);
        return bridgeOverviewDtos;

    }
    private static void handleBridgeWidthEndAdjustment(BridgeSearchDto bridgeSearchDto) {
        Integer bridgeWidthEnd = bridgeSearchDto.getBridgeWidthEnd();
        if (bridgeWidthEnd.equals(0)) {
            bridgeSearchDto.setBridgeWidthEnd(Integer.MAX_VALUE);
        }
    }

    public List<BridgeLocationInfoDto> findBridgeLocationInfosBy(BridgeSearchDto bridgeSearchDto) {
        handleBridgeWidthEndAdjustment(bridgeSearchDto);

        List<Bridge> bridges = bridgeService.findBridgesBy(bridgeSearchDto);
        List<BridgeLocationInfoDto> bridgeLocationInfoDtos = bridgeMapper.toBridgeBasicInfoDtos(bridges);
        return bridgeLocationInfoDtos;
    }



    public List<BridgeLocationInfoDto> findAllBridgeLocationInfos() {
        List<Bridge> bridges = bridgeService.findAllBridges();
        List<BridgeLocationInfoDto> bridgeBasicInfoDtos = bridgeMapper.toBridgeBasicInfoDtos(bridges);
        return bridgeBasicInfoDtos;
    }
}
