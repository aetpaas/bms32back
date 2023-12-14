package bridge.bms32back.domain.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageRepository extends JpaRepository<Image, Integer> {




    @Query("select i from Image i where i.bridge.bridgeId = ?1 and i.type = ?2")
    Image findImageBy(Integer bridgeId, String type);
}

