package bridge.bms32back.business.image;

import bridge.bms32back.domain.image.Image;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Image}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto implements Serializable {
    private Integer id;
    private Integer bridgeBridgeId;
    @NotNull
    private byte[] data;
    @NotNull
    private String type;
}