package bridge.bms32back.business.type;

import bridge.bms32back.domain.type.Type;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Type}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeDto implements Serializable {
    private Integer bridgeTypeId;
    @NotNull
    @Size(max = 255)
    private String bridgeType;
}