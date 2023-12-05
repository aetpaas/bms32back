package bridge.bms32back.business.bridges;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BridgesInfoService {

    @Resource
    private BridgeInfoService bridgeInfoService;

    public void getAllBridgsInfo() {
        bridgeInfoService.findAllBridges
    }
}
