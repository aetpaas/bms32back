package bridge.bms32back.business.bridges;

import bridge.bms32back.business.bridges.dto.BridgeLocationInfoDto;
import bridge.bms32back.business.bridges.dto.BridgeOverviewDto;
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
        List<BridgeLocationInfoDto> filteredBridges = bridgesService.findBridgeLocationInfosBy(bridgeSearchDto);
        return filteredBridges;
    }


}
