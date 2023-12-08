package bridge.bms32back.business.location;

import bridge.bms32back.domain.location.Location;
import bridge.bms32back.domain.location.LocationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationsService {
    @Resource
    private LocationService locationService;

    public List<Location> getAllBridgesCoordinates() {
        List<Location> locations = locationService.getAllBridgesCoordinates();
        return ;

    }
}
