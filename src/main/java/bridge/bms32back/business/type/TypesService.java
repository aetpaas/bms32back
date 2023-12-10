package bridge.bms32back.business.type;

import bridge.bms32back.domain.type.Type;
import bridge.bms32back.domain.type.TypeMapper;
import bridge.bms32back.domain.type.TypeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypesService {
    @Resource
    private TypeService typeService;
    @Resource
    private TypeMapper typeMapper;

    public List<TypeDto> findBridgeTypes() {
        List<Type> types = typeService.findBridgeType();
        List<TypeDto> typeDtos = (List<TypeDto>) typeMapper.toTypeDtos(types);
        return typeDtos;
    }
}
