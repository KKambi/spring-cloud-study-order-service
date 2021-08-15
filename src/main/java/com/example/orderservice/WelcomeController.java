package com.example.orderservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/order-service")
public class WelcomeController {

    private final Environment env;

    @GetMapping("/welcome")
    public String welcome(@RequestHeader("order-request") String header) {
        return "welcome-order-service (header: " + header + ")";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request) {
        log.info("port: {}", request.getServerPort());
        return String.format("Hi, there. This is message from Order service, port: %s",
                env.getProperty("local.server.port"));
    }
}
