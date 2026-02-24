package com.vidisha.shopscale;

import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private List<Product> products = Arrays.asList(
            new Product(1L, "MacBook Pro M3", 125000, "macbook.jpg"),
            new Product(2L, "iPhone 16 Pro", 85000, "iphone.jpg"),
            new Product(3L, "AirPods Pro 2", 22000, "airpods.jpg")
    );

    @GetMapping  // All products
    public List<Product> getProducts() {
        return products;
    }

    @GetMapping("/{id}")  // ← NEW! Single product
    public Optional<Product> getProductById(@PathVariable Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
}
