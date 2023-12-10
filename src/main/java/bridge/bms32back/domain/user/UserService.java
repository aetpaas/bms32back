package bridge.bms32back.domain.user;


import bridge.bms32back.business.Status;
import bridge.bms32back.infrastructure.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findActiveUserBy(String username, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(username, password, Status.ACTIVE);
        return ValidationService.getValidUser(optionalUser);
    }
    public void addNewUser(String username, String password) {
         userRepository.addUser(username, password);
    }
}
