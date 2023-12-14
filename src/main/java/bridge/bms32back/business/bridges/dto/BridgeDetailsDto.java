package bridge.bms32back.business.bridges.dto;

import bridge.bms32back.domain.bridge.Bridge;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link Bridge}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BridgeDetailsDto implements Serializable {
    private Integer bridgeId;
    @NotNull
    private Integer bridgeNumber;
    @NotNull
    @Size(max = 255)
    private String bridgeName;
    @NotNull
    private BigDecimal length;
    @NotNull
    private BigDecimal width;
    private String bridgeTypeName;
    @NotNull
    private Integer conditionIndex;
    private String locationCountyName;
    private BigDecimal locationLatitude;
    private BigDecimal locationLongitude;
    private String materialName;
}