package com.example.orderservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-service")
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome-order-service";
    }
}
