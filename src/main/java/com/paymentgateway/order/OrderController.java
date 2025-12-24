package com.paymentgateway.order;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableMethodSecurity
@RestController
public class OrderController {
    @GetMapping("/order")
    public String order() {
        return "Hello world";
    }

    @GetMapping("/public")
    public String publicApi() {
        return "Public OK";
    }

    @GetMapping("/secure")
    public String secureApi(Authentication auth) {
        return "Hello " + auth.getName();
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminApi() {
        return "Admin OK";
    }
}
