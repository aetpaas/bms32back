package bridge.bms32back.domain.location;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Resource
    private LocationRepository locationRepository;
    public List<Location> getAllBridgesCoordinates() {
        List<Location> locations = locationRepository.findAll();
        return locations;
    }
}
