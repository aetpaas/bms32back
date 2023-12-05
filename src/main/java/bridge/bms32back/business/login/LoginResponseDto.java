package bridge.bms32back.business.login;

import bridge.bms32back.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Data
public class LoginResponseDto implements Serializable {
    private Integer userId;
    private String roleName;
}