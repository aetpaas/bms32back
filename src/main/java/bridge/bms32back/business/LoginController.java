package bridge.bms32back.business;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    public void login(String username, String password) {
        loginService.login(username, password);
    }
}
