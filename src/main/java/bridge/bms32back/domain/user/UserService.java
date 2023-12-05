package bridge.bms32back.domain.user;


import bridge.bms32back.domain.user.User;
import bridge.bms32back.domain.user.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findActiveUserBy(String username, String password) {
        User user = userRepository.findUserBy(username, password, "A");
        return user;


    }
}
