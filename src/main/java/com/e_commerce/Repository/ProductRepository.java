package com.e_commerce.Repository;

import com.e_commerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findProductByCategoryId(Long categoryId);

    List<Product> findProductByStockQuantity(Integer stockQuantity);

    List<Product> findByStockQuantityLessThan(Integer stockQuantity);

    List<Product> findByStockQuantityGreaterThan(Integer stockQuantity);


}
