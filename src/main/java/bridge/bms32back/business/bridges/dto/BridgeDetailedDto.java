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
public class BridgeDetailedDto implements Serializable {
    private Integer bridgeId;
    @NotNull
    private Integer number;
    @NotNull
    @Size(max = 255)
    private String name;
    @NotNull
    private BigDecimal length;
    @NotNull
    private BigDecimal width;
    private Integer typeId;
    private String typeName;
    @NotNull
    private Integer conditionIndex;
    private Integer locationLocationId;
    private Integer locationCountyId;
    private String locationCountyName;
    private BigDecimal locationLatitude;
    private BigDecimal locationLongitude;
    private Integer materialId;
    private String materialName;
}