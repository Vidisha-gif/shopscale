package com.vidisha.shopscale;



import com.vidisha.shopscale.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Auto-generates: save(), findAll(), findById(), deleteById()
}
