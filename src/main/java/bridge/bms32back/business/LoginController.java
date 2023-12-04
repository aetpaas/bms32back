package bridge.bms32back.business;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    public void login(String username, String password, String status) {
        loginService.login(username, password, status);
    }
}
