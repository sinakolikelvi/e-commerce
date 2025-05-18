package com.e_commerce.Controller;

import com.e_commerce.Dto.ProductDto;
import com.e_commerce.Entity.Product;
import com.e_commerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @GetMapping("/category/{categoryId}")
    public List<Product> getAllProductsByCategoryId(@PathVariable Long categoryId){
        return productService.getAllProductsByCategoryId(categoryId);
    }
    @GetMapping("/stock/{stockQuantity}")
    public List<Product> getAllProductByStockQuantity(@PathVariable Integer stockQuantity){
        return productService.getAllProductsByStockQuantity(stockQuantity);
    }

    @GetMapping("/stock/lower-than-{quantity}")
    public List<Product> getLowerStockthan(@PathVariable Integer quantity){
        return productService.getLowerStockthan(quantity);
    }
    @GetMapping("/stock/higher-than-{quantity}")
    public List<Product> getHigherStockthan(@PathVariable Integer quantity){
        return productService.getHigherStockthan(quantity);
    }

    @PostMapping("/add")
    public Product create(@RequestBody ProductDto productDto){
         return productService.createProduct(productDto);
    }

    @PostMapping("/update")
    public Product update(@RequestBody ProductDto productDto){
        return productService.updateProduct(productDto);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        productService.deleteProductById(id);
    }
}
