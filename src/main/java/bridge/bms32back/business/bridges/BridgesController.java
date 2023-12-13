package bridge.bms32back.business.bridges;

import bridge.bms32back.business.bridges.dto.BridgeLocationInfoDto;
import bridge.bms32back.business.bridges.dto.BridgeOverviewDto;
import bridge.bms32back.business.bridges.dto.BridgeSearchDto;
import bridge.bms32back.domain.bridge.Bridge;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BridgesController {

    @Resource
    private BridgesService bridgesService;


    @GetMapping("/bridges/overview/all")
    @Operation(summary = "Tagastab kõikide sildade info Kõik sillad vaatel")
    public List<BridgeOverviewDto> findAllBridgesOverview() {
        List<BridgeOverviewDto> bridgesOverview = bridgesService.findAllBridgesOverview();
        return bridgesOverview;
    }


    @GetMapping("/bridges/location/all")
    @Operation(summary = "Tagastab andmebaasist kõikide sildade asukoha info")
    public List<BridgeLocationInfoDto> findAllBridgeLocationInfos() {
        List<BridgeLocationInfoDto> filteredBridges = bridgesService.findAllBridgeLocationInfos();
        return filteredBridges;

    }

    @PostMapping("/bridges/location/by-criteria")
    @Operation(summary = "Tagastab andmebaasist sildade asukoha info, mis vastavad filtris sisestatud andmetele")
    public List<BridgeLocationInfoDto> findBridgeLocationInfosBy(@RequestBody BridgeSearchDto bridgeSearchDto) {
        List<BridgeLocationInfoDto> bridgeLocationInfoDtos = bridgesService.findBridgeLocationInfosBy(bridgeSearchDto);
        return bridgeLocationInfoDtos;
    }

    @GetMapping("/bridge/")
    public Bridge getBridgeBy(@RequestParam Integer bridgeId){
        Bridge bridge = bridgesService.getBridgeBy(bridgeId);
        return bridge;
    }

}
