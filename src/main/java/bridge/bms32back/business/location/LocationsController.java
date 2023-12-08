package bridge.bms32back.business.location;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationsController {

    @Resource
    private LocationsService locationsService;



    @GetMapping("/locations/all/coordinates")
    public void getAllBridgesCoordinates() {
        locationsService.getAllBridgesCoordinates()

    }
}


