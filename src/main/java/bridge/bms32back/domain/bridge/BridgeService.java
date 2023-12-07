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

    public void findBridgesBy(BridgeSearchDto bridgeSearchDto) {
        bridgeRepository.findBridgesBy(bridgeSearchDto.getBridgeName(),bridgeSearchDto.getBridgeTypeId(),);

    }
