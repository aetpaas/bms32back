package bridge.bms32back.domain.bridge;

import bridge.bms32back.business.bridges.dto.BridgeSearchDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BridgeService {
    @Resource
    private BridgeRepository bridgeRepository;

    public List<Bridge> findAllBridges() {
        List<Bridge> bridges = bridgeRepository.findAll();
        return bridges;
    }

    public List<Bridge> findBridgesBy(BridgeSearchDto bridgeSearchDto) {
        List<Bridge> filteredBridges = bridgeRepository.findBridgesBy(
                bridgeSearchDto.getBridgeName(),
                bridgeSearchDto.getBridgeNumber(),
                bridgeSearchDto.getBridgeTypeId(),
                bridgeSearchDto.getCountyId(),
                bridgeSearchDto.getMaterialTypeId(),
                bridgeSearchDto.getBridgeLengthStart(),
                bridgeSearchDto.getBridgeLengthEnd(),
                bridgeSearchDto.getBridgeWidthStart(),
                bridgeSearchDto.getBridgeWidthEnd(),
                bridgeSearchDto.getConditionIndex());
        return filteredBridges;

    }
}
