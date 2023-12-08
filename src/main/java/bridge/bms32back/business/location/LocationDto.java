package bridge.bms32back.business.location;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link bridge.bms32back.domain.location.Location}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto implements Serializable {
    private Integer id;
    private Integer countyId;
    private String countyName;
    @NotNull
    private BigDecimal latitude;
    @NotNull
    private BigDecimal longitude;
}