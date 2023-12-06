package bridge.bms32back.domain.bridge;

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


}
