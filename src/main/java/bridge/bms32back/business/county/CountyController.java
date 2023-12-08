package bridge.bms32back.business.county;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountyController {
    @Resource
    private CountiesService countiesService;

    @GetMapping("/counties")
    public List<CountyDto> findAllCounties() {
        List<CountyDto> countyDtos = countiesService.getAllCounties();
        return countyDtos;
    }


}
