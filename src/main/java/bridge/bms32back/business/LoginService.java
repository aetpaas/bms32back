package bridge.bms32back.business;

import bridge.bms32back.domain.user.UserService;
import bridge.bms32back.domain.user.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Resource
    private UserService userService;

    public User login(String username, String password, String status) {
        User user = userService.findActiveUserBy(username, password, status);
        return user;

    }
}
