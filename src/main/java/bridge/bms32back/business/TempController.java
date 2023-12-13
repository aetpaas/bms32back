package bridge.bms32back.business;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempController {
    @GetMapping("/calculate/{x}/by/{y}")
    public int multiply(@PathVariable Integer x, @PathVariable Integer y) {

        return x - y;
    }
}
