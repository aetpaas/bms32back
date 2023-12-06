package bridge.bms32back.infrastructure.validation;

import bridge.bms32back.domain.user.User;
import bridge.bms32back.infrastructure.exception.BusinessException;

import java.util.Optional;

import static bridge.bms32back.infrastructure.validation.Error.*;

public class ValidationService {
    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
    return optionalUser.get();
    }
}
