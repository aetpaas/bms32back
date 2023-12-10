package bridge.bms32back.business.adduser;

import bridge.bms32back.business.login.LoginService;
import bridge.bms32back.business.loginDTO.LoginResponseDto;
import bridge.bms32back.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddUserController {
    @Resource
    private LoginService loginService;

    @GetMapping("/adduser")
    @Operation(summary = "Lisab uue kasutaja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Kasutaja on olemas", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    public void addUser(@RequestParam String username, @RequestParam String password) {
      loginService.addUser(username, password);
    }

}
