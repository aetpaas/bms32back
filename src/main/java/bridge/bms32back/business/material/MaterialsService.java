package bridge.bms32back.business.material;

import bridge.bms32back.domain.material.Material;
import bridge.bms32back.domain.material.MaterialMapper;
import bridge.bms32back.domain.material.MaterialService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialsService {
    @Resource
    private MaterialService materialService;
    @Resource
    private MaterialMapper materialMapper;

    public List<MaterialDto> getAllMaterials() {
        List<Material> materials = materialService.getAllMaterials();
        List<MaterialDto> materialDtos = materialMapper.toMaterialDtos(materials);
        return materialDtos;
    }
}
