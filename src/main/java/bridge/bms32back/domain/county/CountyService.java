package bridge.bms32back.domain.county;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyService {
    @Resource
    private CountyRepository countyRepository;

    public List<County> getAllCounties() {
        List<County> counties = countyRepository.findAll();
        return counties;
    }

    public County getCountyBy(Integer locationCountyId) {
        County county = countyRepository.getReferenceById(locationCountyId);
        return county;
    }
}
