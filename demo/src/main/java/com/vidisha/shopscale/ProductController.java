package com.vidisha.shopscale;  // Your current package

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/products")  // Base path
public class ProductController {

    @GetMapping  // GET /api/products
    public List<String> getProducts() {
        return Arrays.asList(
                "Laptop ₹50,000",
                "iPhone ₹80,000",
                "Headphones ₹2,000"
        );
    }
}
