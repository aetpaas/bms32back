package bridge.bms32back.business.type;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeController {
    @Resource
    private TypesService typesService;

    @GetMapping("/types")
    public List<TypeDto> findAllBridgeTypes() {
        List<TypeDto> typeDtos = typesService.findBridgeTypes();
        return typeDtos;
    }

}




