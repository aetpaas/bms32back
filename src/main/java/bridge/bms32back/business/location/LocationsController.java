package bridge.bms32back.business.location;

import bridge.bms32back.domain.location.Location;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationsController {

    @Resource
    private LocationsService locationsService;



    @GetMapping("/locations/all/coordinates")
    public void getAllBridgesCoordinatesAndName() {
         locationsService.getAllBridgesCoordinates();


    }
}


