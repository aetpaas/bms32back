package bridge.bms32back.business.login;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    public LoginResponseDto login(@RequestParam String username,@RequestParam String password) {
        LoginResponseDto loginResponse = loginService.login(username, password);
        return loginResponse;
    }
}
