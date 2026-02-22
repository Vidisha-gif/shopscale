package com.vidisha.shopscale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "🚀 E-commerce Backend Ready! Day 1 Complete.";
    }
}
