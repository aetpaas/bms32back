package bridge.bms32back.business.material;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaterialController {
    @Resource
    private MaterialsService materialsService;

    @GetMapping("/material")
    public List<MaterialDto> findAllMaterials() {
        List<MaterialDto> materialDtos = materialsService.getAllMaterials();
        return materialDtos;
    }
}
