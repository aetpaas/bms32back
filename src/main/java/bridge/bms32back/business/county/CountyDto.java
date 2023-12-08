package bridge.bms32back.business.county;

import bridge.bms32back.domain.county.County;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link County}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountyDto implements Serializable {
    private Integer countyId;
    @NotNull
    @Size(max = 30)
    private String countyName;
}