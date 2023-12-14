package bridge.bms32back.business.bridges;

import bridge.bms32back.business.bridges.dto.BridgeDetailsDto;
import bridge.bms32back.business.bridges.dto.BridgeLocationInfoDto;
import bridge.bms32back.business.bridges.dto.BridgeOverviewDto;
import bridge.bms32back.business.bridges.dto.BridgeRequestDto;
import bridge.bms32back.business.bridges.dto.BridgeSearchDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
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

    @GetMapping("/bridge/{bridgeId}")
    public BridgeDetailsDto getBridgeBy(@PathVariable Integer bridgeId){
        BridgeDetailsDto bridgeDetailedDto = bridgesService.getBridgeBy(bridgeId);
        return bridgeDetailedDto;

    }

    @PostMapping("/bridge")
    @Operation(summary = "Lisab uue silla andmed koos pildi ja huvitava faktiga")
    public void addNewBridge(@RequestBody @Valid BridgeRequestDto bridgeRequestDto) {
        bridgesService.addNewBridge(bridgeRequestDto);

    }

    @DeleteMapping("/bridge")
    public void deleteBridgeInfo(@RequestParam Integer bridgeId) {
        bridgesService.deleteBridgeInfo(bridgeId);

    }
}
