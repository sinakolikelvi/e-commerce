package com.e_commerce.Controller;

import com.e_commerce.Dto.ProductDto;
import com.e_commerce.Entity.Product;
import com.e_commerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
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
    public List<Product> getLowerStockThan(@PathVariable Integer quantity){
        return productService.getLowerStockthan(quantity);
    }
    @GetMapping("/stock/higher-than-{quantity}")
    public List<Product> getHigherStockThan(@PathVariable Integer quantity){
        return productService.getHigherStockthan(quantity);
    }

    @PostMapping("/add")
    public Product create(@RequestBody ProductDto productDto){
         return productService.createProduct(productDto);
    }

    @PostMapping("/add-multiple")
    public List<Product> createMultiple(@RequestBody List<ProductDto> productDtoList){
        return productService.createMiltipleProducts(productDtoList);
    }

    @PostMapping("/update")
    public Product update(@RequestBody ProductDto productDto){
        return productService.updateProduct(productDto);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @GetMapping
    public Page<Product> getProductsPaginated(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productService.getProductsPaginated(pageable);
    }
}
