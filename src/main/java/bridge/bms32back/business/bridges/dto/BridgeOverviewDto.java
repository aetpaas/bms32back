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
public class BridgeOverviewDto implements Serializable {
    private Integer bridgeId;
    @NotNull
    private Integer bridgeNumber;
    @NotNull
    @Size(max = 255)
    private String bridgeName;
    @NotNull
    private BigDecimal bridgeLength;
    @NotNull
    private BigDecimal bridgeWidth;
    private String bridgeType;
    @NotNull
    private Integer conditionIndex;
    private String locationCounty;
    private String bridgeMaterial;
}