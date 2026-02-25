package com.vidisha.shopscale;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private List<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product(1L, "MacBook Pro M3", 125000, "macbook.jpg"));
        products.add(new Product(2L, "iPhone 16 Pro", 85000, "iphone.jpg"));
        products.add(new Product(3L, "AirPods Pro 2", 22000, "airpods.jpg"));
    }

    @GetMapping
    public List<Product> getProducts() { return products; }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        product.setId((long) (products.size() + 1));
        products.add(product);
        return product;
    }

    // ← NEW! Update product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Optional<Product> existing = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        if (existing.isPresent()) {
            Product product = existing.get();
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setImageUrl(updatedProduct.getImageUrl());
            return product;
        }

        return null; // Or throw exception in production
    }
    // ← NEW! Delete product (add after updateProduct method)
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        boolean removed = products.removeIf(p -> p.getId().equals(id));
        if (removed) {
            return "Product with id " + id + " deleted successfully";
        }
        return "Product not found";
    }

}