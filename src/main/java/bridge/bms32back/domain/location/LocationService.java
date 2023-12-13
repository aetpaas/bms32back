package bridge.bms32back.domain.location;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Resource
    private LocationRepository locationRepository;
//
//    public void deleteLocation(Location location) {
//        locationRepository.delete(location);
//
//}

    public void deleteLocationBy(Location location) {
        locationRepository.delete(location);
    }


    public Location createNewLocation(Location location) {
        locationRepository.save(location);
        return location;
    }

}
