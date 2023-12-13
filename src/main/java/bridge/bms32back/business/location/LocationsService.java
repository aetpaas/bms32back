package bridge.bms32back.business.location;

import bridge.bms32back.business.bridges.dto.BridgeAddDto;
import bridge.bms32back.domain.county.County;
import bridge.bms32back.domain.county.CountyService;
import bridge.bms32back.domain.location.Location;
import bridge.bms32back.domain.location.LocationMapper;
import bridge.bms32back.domain.location.LocationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LocationsService {
    @Resource
    private LocationService locationService;

    @Resource
    private LocationMapper locationMapper;
    @Resource
    private CountyService countyService;


    public Location addLocation(BridgeAddDto bridgeAddDto) {
        Location location = locationMapper.toLocation(bridgeAddDto);
        County county = countyService.getCountyBy(bridgeAddDto.getLocationCountyId());
        location.setCounty(county);
        return locationService.createNewLocation(location);

    }
}
