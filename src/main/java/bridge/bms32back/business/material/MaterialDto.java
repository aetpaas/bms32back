package bridge.bms32back.business.material;

import bridge.bms32back.domain.material.Material;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Material}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDto implements Serializable {
    private Integer materialId;
    @NotNull
    @Size(max = 30)
    private String materialName;
}