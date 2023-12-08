package bridge.bms32back.business.location;

import bridge.bms32back.domain.location.LocationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LocationsService {
    @Resource
    private LocationService locationService;
    public void getAllBridgesCoordinates() {
locationService.getAllBridgesCoordinates()

    }
}
