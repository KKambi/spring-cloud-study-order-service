package com.example.orderservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-service")
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(@RequestHeader("order-request") String header) {
        return "welcome-order-service (header: " + header + ")";
    }

    @GetMapping("/check")
    public String check() {
        return "Hi, there. This is message from Order service";
    }
}
