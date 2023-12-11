package bridge.bms32back.domain.material;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    @Resource
    private MaterialRepository materialRepository;

    public List<Material> getAllMaterials() {
        List<Material> materials = materialRepository.findAll();
        return materials;
    }
}
