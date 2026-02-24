package com.vidisha.shopscale;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private List<Product> products = new ArrayList<>(); // Changed to ArrayList

    // Initialize with sample data
    public ProductController() {
        products.add(new Product(1L, "MacBook Pro M3", 125000, "macbook.jpg"));
        products.add(new Product(2L, "iPhone 16 Pro", 85000, "iphone.jpg"));
        products.add(new Product(3L, "AirPods Pro 2", 22000, "airpods.jpg"));
    }

    @GetMapping
    public List<Product> getProducts() {
        return products;
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    // ← NEW! Create product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        product.setId((long) (products.size() + 1)); // Auto-generate ID
        products.add(product);
        return product;
    }
}
