package bridge.bms32back.domain.bridge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link bridge.bms32back.domain.Location}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position implements Serializable {
    private BigDecimal lat;
    private BigDecimal lng;
}