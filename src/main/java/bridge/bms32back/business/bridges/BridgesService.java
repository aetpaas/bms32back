package bridge.bms32back.business.bridges;

import bridge.bms32back.business.bridges.dto.BridgeBasicInfoDto;
import bridge.bms32back.business.bridges.dto.BridgeDto;
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

    public List<BridgeDto> findAllBridges() {
        List<Bridge> bridges = bridgeService.findAllBridges();
        List<BridgeDto> bridgeDtos = bridgeMapper.toBridgeDtos(bridges);
        return bridgeDtos;

    }

    public List<BridgeBasicInfoDto> findBridgesBy(BridgeSearchDto bridgeSearchDto) {
        List<Bridge> bridgesBy = bridgeService.findBridgesBy(bridgeSearchDto);
        List<BridgeBasicInfoDto> bridgeBasicInfoDtos = bridgeMapper.toBridgeBasicInfoDtos(bridgesBy);
        return bridgeBasicInfoDtos;

    }
}
