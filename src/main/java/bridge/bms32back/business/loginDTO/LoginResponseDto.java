package bridge.bms32back.business.loginDTO;

import bridge.bms32back.domain.user.User;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Data
public class LoginResponseDto implements Serializable {
    private Integer userId;
    private String roleName;
}