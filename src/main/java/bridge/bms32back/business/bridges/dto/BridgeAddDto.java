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
public class BridgeAddDto implements Serializable {
    @NotNull
    private Integer bridgeNumber;
    @NotNull
    @Size(max = 255)
    private String bridgeName;
    @NotNull
    private BigDecimal length;
    @NotNull
    private BigDecimal width;
    @NotNull
    private Integer bridgeTypeId;
    @NotNull
    private Integer conditionIndex;
    @NotNull
    private Integer locationCountyId;
    @NotNull
    private BigDecimal locationLatitude;
    @NotNull
    private BigDecimal locationLongitude;
    @NotNull
    private Integer materialId;
}