package bridge.bms32back.business.bridges.dto;

import bridge.bms32back.domain.location.Location;
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
public class Position implements Serializable {
    private BigDecimal lat;
    private BigDecimal lng;
}