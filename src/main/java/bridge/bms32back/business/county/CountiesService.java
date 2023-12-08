package bridge.bms32back.business.county;

import bridge.bms32back.domain.county.County;
import bridge.bms32back.domain.county.CountyMapper;
import bridge.bms32back.domain.county.CountyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountiesService {
    @Resource
    private CountyService countyService;
    @Resource
    private CountyMapper countyMapper;

    public List<CountyDto> getAllCounties() {
        List<County> counties = countyService.getAllCounties();
        List<CountyDto> countyDtos = countyMapper.toCountyDtos(counties);
        return countyDtos;

    }

}


