package bridge.bms32back.business.bridges;

import bridge.bms32back.business.bridges.dto.BridgeBasicInfoDto;
import bridge.bms32back.business.bridges.dto.BridgeDto;
import bridge.bms32back.business.bridges.dto.BridgeSearchDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BridgesController {

    @Resource
    private BridgesService bridgesService;


    @GetMapping("/bridges/all")
    @Operation(summary = "Tagastab kõikide sildade info")
    public List<BridgeDto> findAllBridges() {
        List<BridgeDto> bridges = bridgesService.findAllBridges();
        return bridges;
    }


    @PostMapping("/bridges/criteria")
    @Operation(summary = "Tagastab andmebaasist sillad, mis vastavad filtris sisestatud andmetele")
    public List<BridgeBasicInfoDto> findBridgesBy(@RequestBody BridgeSearchDto bridgeSearchDto) {
        List<BridgeBasicInfoDto> bridgesBy = bridgesService.findBridgesBy(bridgeSearchDto);
        return bridgesBy;
    }


}
