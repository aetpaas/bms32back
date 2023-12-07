package bridge.bms32back.domain.bridge;

import bridge.bms32back.business.bridges.dto.BridgeDto;
import bridge.bms32back.business.bridges.dto.BridgeSearchDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;


public interface BridgeRepository extends JpaRepository<Bridge, Integer> {


    @Query("""
            select b from Bridge b
            where b.name = :name
            and b.number = :number
            and b.type.id = :typeId
            and b.location.county.id = :countyId
            and b.material.id = :materialId
            and (b.length between :lengthStart and :lengthEnd)
            and b.width between :widthStart and :widthEnd
            and b.conditionIndex >= :conditionIndex""")
    List<Bridge> findBridgesBy(String name, Integer number, Integer typeId, Integer countyId, Integer materialId, Integer lengthStart, Integer lengthEnd, Integer widthStart, BigDecimal widthEnd, Integer conditionIndex);


}