package bridge.bms32back.business.location;

import bridge.bms32back.domain.location.Location;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link Location}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto implements Serializable {
    private Integer locationId;
    private Integer countyId;
    private String countyName;
    @NotNull
    private BigDecimal latitude;
    @NotNull
    private BigDecimal longitude;
}