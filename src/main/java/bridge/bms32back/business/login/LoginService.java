package bridge.bms32back.business.login;

import bridge.bms32back.business.loginDTO.LoginResponseDto;
import bridge.bms32back.domain.user.User;
import bridge.bms32back.domain.user.UserMapper;
import bridge.bms32back.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;


    public LoginResponseDto login(String username, String password) {
        User user = userService.findActiveUserBy(username, password);
        return userMapper.toLoginResponse(user);

    }

    public void addUser(String username, String password) {
       userService.addNewUser(username, password);
    }
}
