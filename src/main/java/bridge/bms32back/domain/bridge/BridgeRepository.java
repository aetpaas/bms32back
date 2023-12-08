package bridge.bms32back.domain.bridge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BridgeRepository extends JpaRepository<Bridge, Integer> {


    @Query("""
            select b from Bridge b
            where upper(b.name) like upper(concat('%', :name, '%'))
            and b.number = :number
            and (b.type.id = :typeId or :typeId = 0)
            and b.location.county.id = :countyId
            and b.material.id = :materialId
            and (b.length between :lengthStart and :lengthEnd)
            and (b.width between :widthStart and :widthEnd)
            and b.conditionIndex between :conditionIndexStart and :conditionIndexEnd""")
    List<Bridge> findBridgesBy(String name, Integer number, Integer typeId, Integer countyId, Integer materialId, Integer lengthStart, Integer lengthEnd, Integer widthStart, Integer widthEnd, Integer conditionIndexStart, Integer conditionIndexEnd);


}