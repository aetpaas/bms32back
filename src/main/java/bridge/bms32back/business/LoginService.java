package bridge.bms32back.business;

import bridge.bms32back.domain.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Resource
    private UserService userService;

    public void login(String username, String password) {
        userService.findActiveUserBy(username, password)

    }
}
