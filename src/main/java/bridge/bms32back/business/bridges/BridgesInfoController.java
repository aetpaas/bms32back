package bridge.bms32back.business.bridges;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BridgesInfoController {

    @Resource
    private BridgesInfoService bridgesInfoService;

    @GetMapping("/allbridges")
    public void getBridgesInfo() {
        bridgesInfoService.findAllBridgesInfo
    }
}
