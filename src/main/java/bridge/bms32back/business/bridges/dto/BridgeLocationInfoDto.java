package bridge.bms32back.business.bridges.dto;

import bridge.bms32back.domain.bridge.Bridge;
import bridge.bms32back.domain.bridge.Position;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Bridge}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BridgeLocationInfoDto implements Serializable {
    private Integer bridgeId;
    @NotNull
    @Size(max = 255)
    private String bridgeName;
    private Position position;

}